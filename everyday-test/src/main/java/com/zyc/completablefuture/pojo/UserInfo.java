package com.zyc.completablefuture.pojo;

public class UserInfo {

    private String name;

    private String desc;

    private int age;

    public UserInfo() {
    }

    public UserInfo(String name, String desc, int age) {
        this.name = name;
        this.desc = desc;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", age=" + age +
                '}';
    }
}
