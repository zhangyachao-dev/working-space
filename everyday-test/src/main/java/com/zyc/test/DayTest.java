package com.zyc.test;

import cn.hutool.Hutool;
import cn.hutool.log.Log;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.zyc.utils.RegularExpression;
import org.apache.commons.collections4.CollectionUtils;

import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class DayTest {
    private static final Log log = Log.get();
    public static void main(String[] args) {
        DayTest dayTest = new DayTest();
        String s = dayTest.reflectStr("ef");
        System.out.println(s);
        //Hutool.printAllUtils();
       //Lists.newArrayList(allUtils).forEach(System.out::println);
        //System.out.println(System.currentTimeMillis());
    }

    private void json(){
        Map<Object, Object> hashMap = Maps.newHashMap();
        hashMap.put("deployDir", "/data/bes");
        String string = JSONObject.toJSONString(hashMap);
        System.out.println(string);
    }

    private void strSub(){
        String qqqq = "/sdasdsdad/sdadasd/agent start";
        System.out.println(qqqq.length());
        System.out.println(qqqq.substring(0,qqqq.lastIndexOf("/")));
        System.out.println(qqqq.substring(0, qqqq.length() -2));
        System.out.println(qqqq.substring(0, qqqq.length() -1));
    }

        private void strBuild(){
        String a = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append(",");
        System.out.println(stringBuilder.toString().substring(0, stringBuilder.toString().length() -1));
    }

    private void listsRemove2(){
        List<String> l1 = Lists.newArrayList();
        l1.add("a");
        l1.add("b");
        l1.add("c");
        l1.add("d");
        l1.add("e");
        l1.add("f");
        List<String> l2 = Lists.newArrayList(l1);
        l2.remove("c");
        l1.forEach(System.out::println);
        System.out.println("----------");
        l2.forEach(System.out::println);

    }

    private void listsRemove(){
        List<String> l1 = Lists.newArrayList();
        l1.add("a");
        l1.add("b");
        l1.add("c");
        l1.add("d");
        l1.add("e");
        l1.add("f");
        List<String> l2 = Lists.newArrayList(l1);
        l2.add("12323");
        l2.remove("b");
        System.out.println("---------l1-----------");
        l1.forEach(System.out::println);
        System.out.println("---------l2-----------");
        l2.forEach(System.out::println);
    }

    private void collectionsOps(){
        List<String> l1 = Lists.newArrayList();
        l1.add("a");
        l1.add("b");
        l1.add("c");
        l1.add("d");
        l1.add("e");
        l1.add("f");
        List<String> l2 = Lists.newArrayList();
        /*l2.add("a");
        l2.add("b");
        l2.add("c");*/
        l2.add("d");
        l2.add("e");
        l2.add("f");

        List<String> l3 = (List<String>)CollectionUtils.disjunction(l1,l2);
        l3.forEach(System.out::println);
    }

    private void strFormat(){
        String a = String.format("/sad/%s", "qqqqqqqqqqqqqq");
        CopyOnWriteArrayList<Object> list = new CopyOnWriteArrayList<>();
        System.out.println(a);
    }

    private int strHash(String str){
        return str.hashCode();
    }

    private void time(){
        long millis = TimeUnit.HOURS.toMillis(1);
        System.out.println(millis);
    }

    private void regx(String str){
        boolean matches = str.matches(RegularExpression.REGX_URL);
        System.out.println(matches);
    }

    private void lambdaList(){
        List<User> users = Lists.newArrayList();
        users.add(new User(1,"aaa"));
        users.add(new User(3,"aaa"));
        users.add(new User(65,"aaa"));
        users.add(new User(8,"aaa"));

        users.forEach(user -> {
            if(user.getId() == 3){
                user.setName("ppp");
            }
        });
        users.forEach(System.out::println);
    }

    private void checkUri(){
        String address = "https://www.baidu.com:9987/aaaad";
        //URI uri = URI.create(address);
        try {
            URI uri = new URI(address);
            System.out.println(uri.getPort());
            System.out.println(uri.getScheme());

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private void doubleToInt(){
        String str = "3000.0";
        double v = Double.parseDouble(str);
        Integer a = (int) v;
        System.out.println(a);
    }

    private void listRemoveCp(){
        List<String> lists = Lists.newArrayList();
        lists.add("123");
        lists.add("1234");
        lists.add("1231");
        lists.add("12343523");
        String ip = "aas";
        Lists.newArrayList(lists).forEach(item -> {
            if("1231".equals(item)){
                lists.remove(item);
            }
        });
        lists.forEach(System.out::println);
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
        String a = "/home/da/eee/uuq/aa.sh/";
        String b = "/home/da/eee/uuq/bb.sh/";
        String c = "/home/da/eee/uuq1/aa.sh";
        String d = "/home/da/eee/uuq2/bb.sh";
        if(c.endsWith("/")){
            System.out.println(c.substring(0, c.length() - 1));
        }else{
            System.out.println("else: " + c);
        }

        System.out.println(d.substring(0, d.lastIndexOf("/")));

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

    private void strSubs(){
        String dir = "/home/zyc/usermanger/sd/er/start.sh/";
        if(dir.endsWith("/")){
            dir = dir.substring(0, dir.length() -1);
            System.out.println(dir);
        }
        String a = dir.substring(0, dir.lastIndexOf("/"));
        String b = dir.substring(dir.lastIndexOf("/") + 1, dir.length());
        System.out.println(a);
        System.out.println(b);
    }

    private String reflectStr(String s){
        Class<? extends String> clazz = s.getClass();
        try {
            Field value = clazz.getDeclaredField("value");
            value.setAccessible(true);
            value.set(s, new char[]{'1','e','f','2'});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

}
