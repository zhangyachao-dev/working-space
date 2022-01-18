package com.zyc.locak.jvmlock;

import cn.hutool.log.Log;
import com.zyc.locak.jvmlock.pojo.Machine;

public class SynchronizedDemo2 {

    private static final Log log = Log.get();

    public void concurrencyHunt(Machine machine, String task){
        //log.info("asd");
        exeService(machine.getIp(), task);

    }

    /**
     * 类 String 维护一个字符串池。 当调用 intern 方法时，
     * 如果池已经包含一个等于此 String 对象的字符串（该对象由 equals(Object) 方法确定），
     * 则返回池中的字符串。可见，当String相同时，String.intern()总是返回同一个对象，
     * 因此就实现了对同一用户加锁。由于锁的粒度局限于具体用户，使系统获得了最大程度的并发。
     * @param ip
     * @param serviceId
     */
    private void exeService(String ip, String serviceId){
        String lock = new String(ip);
        log.info("现在执行业务的机器是：{}，任务为：{}", ip, serviceId);
        synchronized(ip.intern()){
            try {
                Thread.sleep(6 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("机器是：{}，任务：{}，执行完成。。。", ip, serviceId);
    }

}
