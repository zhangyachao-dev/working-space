package com.zyc.locak.jvmlock;

import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedDemo1 {

    private int num;

    // 原子操作Atomic
    private AtomicInteger atomicNum = new AtomicInteger();

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getAtomicNum() {
        return atomicNum.get();
    }

    /**
     * synchronized 修饰类成员方法，锁（this）对象
     * synchronized 修饰静态方法，锁 class
     * jdk1.6之前加锁的是monitor,将线程阻塞放入队列中
     */
    public synchronized void autoIncrement1(){
        num++;
    }

    public void autoIncrement2(){
        synchronized(this){
            num++;
        }
    }

    public void autoIncrement3(){
        atomicNum.incrementAndGet();
    }

}
