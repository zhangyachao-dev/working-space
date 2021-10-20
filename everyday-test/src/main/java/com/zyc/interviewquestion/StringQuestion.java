package com.zyc.interviewquestion;

public class StringQuestion {

    public static void main(String[] args) {

    }

    private void string1(){
        String a = "abc";
        Class<? extends String> clazz = a.getClass();

        System.out.println(a);
    }


}