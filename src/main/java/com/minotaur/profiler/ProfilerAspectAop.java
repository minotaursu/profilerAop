package com.minotaur.profiler;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Service;

/**
 * ********************************
 * Created by minotaur on 2017/4/12. *
 * ********************************
 * NOTE!!
 * 不支持调用内部方法 innerMethod
 * 不支持private,protected方法
 * 不支持类级别的注释,只能注解method
 * 不支持一个method有多个注解
 *
 * 上述不支持源于spring的AOP机制,如需要支持使用BeanNameAutoProxyCreator来创建代理
 */
@Service
@Aspect
public class ProfilerAspectAop {

    private static final Log profilerLogger = LogUtils.PROFILER_LOGGER;
    private static final Log metricsLogger  = LogUtils.METRICS_LOGGER;
    private static final Log warnLog        = LogUtils.WARN_LOGGER;

    /**
     * 对annotation进行拦截
     */
    @Around("within(@org.springframework.stereotype.Service *)||"
            + "within(@org.springframework.stereotype.Repository *)")
    public Object profiler(ProceedingJoinPoint pjp) throws Throwable {
        return invoke(pjp);
    }

    public Object invoke(ProceedingJoinPoint pjp) throws Throwable {
        boolean profilerSwitch = ProfilerSwitch.getInstance().isOpenProfilerTree();
        if (!profilerSwitch) {
            return pjp.proceed();
        }
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        String clazzName = pjp.getTarget().toString();
        Method method = methodSignature.getMethod();
        String methodName = this.getClassAndMethodName(clazzName, method);
        if (null == methodName) {
            return pjp.proceed();
        }
        try {
            if (Profiler.getEntry() == null) {
                Profiler.start(methodName);
            } else {
                Profiler.enter(methodName);
            }
            return pjp.proceed();
        } catch (Throwable e) {
            warnLog.warn("profiler " + methodName + " error");
            throw e;
        } finally {
            Profiler.release();
            //当root entry为状态为release的时候，打印信息，并做reset操作
            Profiler.Entry rootEntry = Profiler.getEntry();
            if (rootEntry != null) {
                if (rootEntry.isReleased()) {
                    long duration = rootEntry.getDuration();
                    if (duration > ProfilerSwitch.getInstance().getInvokeTimeout()) {
                        profilerLogger.info("\n" + Profiler.dump() + "\n");
                        metricsLogger.info("\n" + Profiler.metrics() + "\n");
                    }
                    Profiler.reset();
                }
            }
        }
    }

    private String getClassAndMethodName(String clazzName, Method method) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(Profiler.split(clazzName, "@")[0]);
            sb.append(":").append(method.getName());
            sb.append("(param:").append(method.getParameterTypes().length);
            sb.append(")");
            return sb.toString();
        } catch (Throwable e) {
            return null;
        }
    }
}
