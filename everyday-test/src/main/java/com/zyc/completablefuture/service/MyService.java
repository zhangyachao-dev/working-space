package com.zyc.completablefuture.service;

import com.zyc.completablefuture.pojo.MedalInfo;
import com.zyc.completablefuture.pojo.UserInfo;

public class MyService {

    /*
     * 模拟两个取数据的任务
     */
    public UserInfo getUserInfo(long userId) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new UserInfo("666", "捡田螺的小男孩", 27);
    }

    public MedalInfo getMedalInfo(long userId) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new MedalInfo("666", "守护勋章");
    }

}
