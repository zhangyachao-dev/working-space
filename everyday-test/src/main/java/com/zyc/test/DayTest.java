package com.zyc.test;

import cn.hutool.log.Log;
import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class DayTest {
    private static final Log log = Log.get();
    public static void main(String[] args) {
        DayTest dayTest = new DayTest();
        dayTest.threadTest();
    }

    private void threadTest(){
        List<String> lists = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            lists.add("zyc"+i);
        }
        lists.forEach(item -> {
            CompletableFuture.runAsync(() -> {
                log.info(Thread.currentThread().getName() + item);
                println();
                System.out.println(Thread.currentThread().getName() + "遍历结束");
            });
        });

        try {
            Thread.sleep(1000 * 60 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private synchronized void println(){
        try {
            System.out.println(Thread.currentThread().getName() + "进入同步方法");
            Thread.sleep(6 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "同步方法结束");
    }


    private void strTest(){
        //String a = "/asdasdasd/";
        //String b = a.substring(0,a.length() - 1);
        //System.out.println(b);
        //Hutool.printAllUtils();
        /*String aa = "asdasd";
        String aaq = "asdasd ";
        System.out.println(aa.equals(aaq));
        log.info("adasds{}","-------");*/
        /*Boolean aa = null;
        if(aa){
            System.out.println("aa");
        }*/

        /*String a = "";

        String b = "";
        String c = a + b;
        System.out.println(c);*/

        //String a = "sadUUda-dadasda-dasdasd";
        //System.out.println(a.replace("-",""));
        //System.out.println(a.toLowerCase());
        //System.out.println(a.toUpperCase());

        //String b = "sadUUda-dadasda-dasdasd";
        //System.out.println(a.replaceAll("-",""));
    }

    private void listSort(){
        List<User> list = Lists.newArrayList();
        list.add(new User(1,"aaa"));
        list.add(new User(3,"aaa"));
        list.add(new User(65,"aaa"));
        list.add(new User(8,"aaa"));
        List<User> userList = list.stream().sorted(Comparator.comparing(User::getId)).collect(Collectors.toList());
        userList.forEach(System.out::println);
    }

    private void listRemove(){
        List<User> lists = Lists.newArrayList();
        lists.add(new User(1,"aaa"));
        lists.add(new User(3,"aaa"));
        lists.add(new User(65,"aaa"));
        lists.add(new User(8,"aaa"));
        User user = lists.stream().filter(item -> {
            return item.getId() == 3;
        }).collect(Collectors.toList()).get(0);
        lists.remove(user);
        lists.forEach(System.out::println);
    }

}