package com.minotaur.profiler;

import java.io.FileNotFoundException;

import org.springframework.util.Log4jConfigurer;

/**
 * ********************************
 * Created by minotaur on 2017/4/12. *
 * ********************************
 */
public class Log4jConfigListener {

    private int    refreshInterval = 60;
    private String location        = "classpath:log4j.xml";

    public void setRefreshInterval(int refreshInterval) {
        this.refreshInterval = refreshInterval;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void init() {
        try {
            Log4jConfigurer.initLogging(location, refreshInterval);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        Log4jConfigurer.shutdownLogging();
    }

}
