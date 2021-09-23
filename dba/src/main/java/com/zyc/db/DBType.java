package com.zyc.db;

public enum DBType {
    MYSQL(1,"zyc_mysql","mysql数据库"),
    ORACLE(2,"zyc_oracle","oracle数据库")
    ;
    private int code;

    private String name;

    private String desc;

    DBType(int code, String name, String desc) {
        this.code = code;
        this.name = name;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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
}
