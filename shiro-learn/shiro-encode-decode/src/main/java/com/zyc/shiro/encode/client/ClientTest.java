package com.zyc.shiro.encode.client;

import com.zyc.shiro.encode.tool.DigestsUtil;
import com.zyc.shiro.encode.tool.EncodesUtil;
import org.junit.Test;

import java.util.Map;

/**
 * @author yachao.zhang
 */
public class ClientTest {

    @Test
    public void hexTest() {
        String input = "hello";
        String encodeHex = EncodesUtil.encodeHex(input.getBytes());
        String decode = new String(EncodesUtil.decodeHex(encodeHex));
        System.out.println(encodeHex);
        System.out.println(decode);
    }

    @Test
    public void base64Test() {
        String input = "hello";
        String encode = EncodesUtil.encodeBase64(input.getBytes());
        String dencode = new String(EncodesUtil.decodeBase64(encode));
        System.out.println(encode);
        System.out.println(dencode);
    }

    @Test
    public void testDigestsUtil(){
        Map<String,String> map =  DigestsUtil.entryptPassword("123");
        System.out.println("获得结果："+map.toString());
    }

}
