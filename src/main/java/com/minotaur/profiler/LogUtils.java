package com.minotaur.profiler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by minotaur on 16/1/26.
 */
public class LogUtils {

    /**
     * profiler日志
     */
    public static final Log PROFILER_LOGGER = LogFactory.getLog("profilerLogger");
    /**
     * metrics日志
     */
    public static final Log METRICS_LOGGER = LogFactory.getLog("metricsLogger");
    /**
     * 警告日志
     */
    public static final Log WARN_LOGGER     = LogFactory.getLog("warnLogger");

}
