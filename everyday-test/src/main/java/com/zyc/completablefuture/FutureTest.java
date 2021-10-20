package com.zyc.completablefuture;

import com.zyc.completablefuture.pojo.MedalInfo;
import com.zyc.completablefuture.pojo.UserInfo;
import com.zyc.completablefuture.service.MyService;

import java.util.concurrent.*;

/**
 * @see Future
 * @see FutureTask
 * Future.get() 就是阻塞调用，在线程获取结果之前get方法会一直阻塞。
 * Future提供了一个isDone方法，可以在程序中轮询这个方法查询执行结果。
 */
public class FutureTest {

    public static void main(String[] args) {
        FutureTest futureTest = new FutureTest();
        //futureTest.useFutureTask();
        futureTest.useCompletableFuture();
    }

    private void useCompletableFuture(){
        MyService myService = new MyService();
        long userId =666L;
        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("获取数据前总共用时" + (System.currentTimeMillis() - startTime) + "ms");
        CompletableFuture<UserInfo> userInfoCompletableFuture = CompletableFuture.supplyAsync(() -> {
            return myService.getUserInfo(userId);
        });
        CompletableFuture<MedalInfo> medalInfoCompletableFuture = CompletableFuture.supplyAsync(() -> {
            return myService.getMedalInfo(userId);
        });
        System.out.println("获取数据前总共用时" + (System.currentTimeMillis() - startTime) + "ms");
        UserInfo userInfo = userInfoCompletableFuture.join();
        MedalInfo medalInfo = medalInfoCompletableFuture.join();
        System.out.println("useCompletableFuture");
        System.out.println(userInfo);
        System.out.println(medalInfo);
        System.out.println("获取数据后总共用时" + (System.currentTimeMillis() - startTime) + "ms");
    }

    private void useFutureTask() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        MyService myService = new MyService();
        long userId =666L;
        long startTime = System.currentTimeMillis();
        FutureTask<UserInfo> userInfoFutureTask = new FutureTask<>(new Callable<UserInfo>() {
            @Override
            public UserInfo call() throws Exception {
                return myService.getUserInfo(userId);
            }
        });
        executorService.submit(userInfoFutureTask);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        FutureTask<MedalInfo> medalInfoFutureTask = new FutureTask<>(new Callable<MedalInfo>() {
            @Override
            public MedalInfo call() throws Exception {
                return myService.getMedalInfo(userId);
            }
        });
        executorService.submit(medalInfoFutureTask);

        // 获取结果 get()阻塞主线程
        UserInfo userInfo = null;
        MedalInfo medalInfo = null;
        try {
            userInfo = userInfoFutureTask.get();
            medalInfo = medalInfoFutureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("useFutureTask");
        System.out.println(userInfo);
        System.out.println(medalInfo);
        System.out.println("总共用时" + (System.currentTimeMillis() - startTime) + "ms");
        executorService.shutdown();
    }


}
