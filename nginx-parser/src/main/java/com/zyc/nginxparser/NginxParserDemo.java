package com.zyc.nginxparser;

import com.github.odiszapc.nginxparser.NgxBlock;
import com.github.odiszapc.nginxparser.NgxConfig;
import com.github.odiszapc.nginxparser.NgxDumper;
import com.github.odiszapc.nginxparser.NgxParam;

import java.io.IOException;

public class NginxParserDemo {

    public static void main(String[] args) {
        NginxParserDemo nginxParserDemo = new NginxParserDemo();
        try {
            nginxParserDemo.test2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void test2() throws IOException {
        NgxConfig ngxConfig = NgxConfig.read("E:\\tmp\\testnginx\\nginx.conf");
        NgxBlock httpBlock = ngxConfig.findBlock("http");
        NgxBlock ngxBlockUpstream = new NgxBlock();
        ngxBlockUpstream.addValue("upstream");
        ngxBlockUpstream.addValue("book-add");
        NgxParam ngxParam = new NgxParam();
        ngxParam.addValue("server");
        ngxParam.addValue("192.168.19.32:4567");
        ngxBlockUpstream.addEntry(ngxParam);
        ngxParam = new NgxParam();
        ngxParam.addValue("server 192.168.18.31:4567");
        ngxBlockUpstream.addEntry(ngxParam);
        httpBlock.addEntry(ngxBlockUpstream);
        String dump = new NgxDumper(ngxConfig).dump();
        System.out.println(dump);
    }

    private void test1() throws Exception {

        NgxConfig ngxConfig = NgxConfig.read("E:\\tmp\\testnginx\\nginx.conf");
        //NgxParam ngxServerParam = ngxConfig.findParam("http", "server");
        NgxBlock block = ngxConfig.findBlock("http");
        NgxBlock ngxBlockServer = new NgxBlock();
        ngxBlockServer.addValue("server");
        NgxParam ngxParamServer = new NgxParam();
        ngxParamServer.addValue("listen 6700");
        ngxBlockServer.addEntry(ngxParamServer);
        ngxParamServer = new NgxParam();
        ngxParamServer.addValue("server_name localhost");
        ngxBlockServer.addEntry(ngxParamServer);
        /*ngxParamServer = new NgxParam();
        ngxParamServer.addValue("server_name localhost");*/
        NgxBlock ngxBlockLocation = new NgxBlock();
        ngxBlockLocation.addValue("location");
        ngxBlockLocation.addValue("/api");
        NgxParam ngxParam = new NgxParam();
        ngxParam.addValue("proxy_pass http://backend_http");
        ngxBlockLocation.addEntry(ngxParam);
        ngxParam = new NgxParam();
        ngxParam.addValue("proxy_set_header Host $host");
        ngxBlockLocation.addEntry(ngxParam);
        ngxParam = new NgxParam();
        ngxParam.addValue("proxy_set_header X-Real-IP $remote_addr");
        ngxBlockLocation.addEntry(ngxParam);
        ngxParam = new NgxParam();
        ngxParam.addValue("proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for");
        ngxBlockLocation.addEntry(ngxParam);
        ngxBlockServer.addEntry(ngxBlockLocation);
        block.addEntry(ngxBlockServer);
        String dump = new NgxDumper(ngxConfig).dump();
        System.out.println(dump);
    }

}
