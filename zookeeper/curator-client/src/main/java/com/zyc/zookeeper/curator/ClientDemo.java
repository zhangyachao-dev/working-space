package com.zyc.zookeeper.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class ClientDemo {

    private final static String zookeeperAddr = "192.168.19.12:2181,192.168.19.12:2182,192.168.19.12:2183";

    public static void main(String[] args) {
        ClientDemo clientDemo = new ClientDemo();
        clientDemo.test1("/clientDemo314");
    }

    private void test1(String path){
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client =
                CuratorFrameworkFactory.builder()
                        .connectString(zookeeperAddr)
                        .sessionTimeoutMs(30000)
                        .connectionTimeoutMs(30000)
                        .retryPolicy(retryPolicy)
                        //.namespace("base_demo")
                        .build();
        client.start();
        try {
            String data = "192.168.19.111:8980";
            Stat stat = client.checkExists().forPath(path);
            System.out.println(stat);
            client.create().withMode(CreateMode.EPHEMERAL).forPath(path, data.getBytes());
            //client.create().forPath(path, data.getBytes());
            Thread.sleep(5 * 1000);
            byte[] bytes = client.getData().forPath(path);
            if(Objects.nonNull(bytes) && bytes.length > 0) {
                String s = new String(bytes);
                System.out.println("节点数据："+s);
            } else {
                System.out.println("数据为空");
            }
            //Thread.sleep(10 * 1000);
            //client.close();
            TimeUnit.HOURS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
