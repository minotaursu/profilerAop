package com.minotaur.profiler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ********************************
 * Created by minotaur on 2017/4/12. *
 * ********************************
 */
@Service
public class ProfilerServiceImpl implements ProfilerService {

    @Autowired
    private ProfilerDAO profilerDAO;

    @Override
    public void onedotone(String param) {
        try {
            Thread.sleep(10l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        profilerDAO.twodotone(21);
        profilerDAO.twodottwo(22);
    }

    @Override
    public void onedottwo(String param) {
        try {
            Thread.sleep(10l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        profilerDAO.twodottwo(22);
    }
}
