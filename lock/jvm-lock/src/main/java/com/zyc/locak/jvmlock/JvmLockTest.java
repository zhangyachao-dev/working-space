package com.zyc.locak.jvmlock;

import cn.hutool.log.Log;
import com.google.common.collect.Lists;
import com.zyc.locak.jvmlock.pojo.Machine;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author zhangyachao
 */
public class JvmLockTest {
    private static final Log log = Log.get();

    public static void main(String[] args) {
        //threadLockTest1();
        threadLockTest2(5);
    }

    public static void threadLockTest1(){
        SynchronizedDemo1 synchronizedDemo = new SynchronizedDemo1();
        long startTime = System.currentTimeMillis();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    synchronizedDemo.autoIncrement3();
                }
            }
        });
        t1.start();

        for (int i = 0; i < 1000000; i++) {
            synchronizedDemo.autoIncrement3();
        }
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        log.info("执行时间：{}ms", endTime - startTime);
        log.info("执行结果：{}", synchronizedDemo.getAtomicNum());
    }

    public static void threadLockTest2(int threadNum){
        long startTime = System.currentTimeMillis();
        SynchronizedDemo2 synchronizedDemo2 = new SynchronizedDemo2();
        List<String> ips = Lists.newArrayList();
        for (int i = 0; i < threadNum; i++) {
            if(i % 2 == 0){
                ips.add("192.168.19.1" + i);
                ips.add("192.168.19.1" + i);
            }else{
                ips.add("192.168.19.1" + i);
            }
        }
        //ips.forEach(System.out::println);
        List<CompletableFuture<Void>> futures = Lists.newArrayList();
        for (int i = 0; i < threadNum; i++) {
            int finalI = i;
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                Machine machine = new Machine("machine" + (finalI + 1), ips.get(finalI));
                synchronizedDemo2.concurrencyHunt(machine, "业务" + (finalI + 1));
            });
            futures.add(future);
        }
        for (CompletableFuture<Void> future : futures) {
            future.join();
        }
        long endTime = System.currentTimeMillis();
        log.info("所有任务执行完成，耗时：{}ms", endTime - startTime);
    }
}
