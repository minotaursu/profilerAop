package com.minotaur.profiler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ********************************
 * Created by minotaur on 2017/4/12. *
 * ********************************
 */
@Service
public class ProfilerDemoImpl implements ProfilerDemo {

    @Autowired
    private ProfilerService profilerService;

    @Override
    public void rootMethod(String param) {
        try {
            Thread.sleep(10l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        profilerService.onedotone("1.1");
        profilerService.onedottwo("1.2");
    }
}
