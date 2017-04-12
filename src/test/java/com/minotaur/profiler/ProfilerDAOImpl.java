package com.minotaur.profiler;

import org.springframework.stereotype.Repository;

/**
 * ********************************
 * Created by minotaur on 2017/4/12. *
 * ********************************
 */
@Repository
public class ProfilerDAOImpl implements ProfilerDAO {

    @Override
    public void twodotone(Integer param) {
        try {
            Thread.sleep(10l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void twodottwo(Integer param) {
        try {
            Thread.sleep(10l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
