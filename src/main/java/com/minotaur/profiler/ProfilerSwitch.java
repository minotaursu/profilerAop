package com.minotaur.profiler;

/**
 * ********************************
 * Created by minotaur on 2017/4/12. *
 * ********************************
 */
public class ProfilerSwitch {

    private static final ProfilerSwitch instance = new ProfilerSwitch();

    public static ProfilerSwitch getInstance() {
        return instance;
    }

    private boolean openProfilerTree     = true;

    private long    invokeTimeout        = 50;

    private boolean openProfilerNanoTime = false;

    public boolean isOpenProfilerTree() {
        return openProfilerTree;
    }

    public void setOpenProfilerTree(boolean openProfilerTree) {
        this.openProfilerTree = openProfilerTree;
    }

    public long getInvokeTimeout() {
        return invokeTimeout;
    }

    public void setInvokeTimeout(long invokeTimeout) {
        this.invokeTimeout = invokeTimeout;
    }

    public boolean isOpenProfilerNanoTime() {
        return openProfilerNanoTime;
    }

    public void setOpenProfilerNanoTime(boolean openProfilerNanoTime) {
        this.openProfilerNanoTime = openProfilerNanoTime;
    }
}
