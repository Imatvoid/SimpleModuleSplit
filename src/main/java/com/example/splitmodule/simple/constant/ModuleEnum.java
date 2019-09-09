package com.example.splitmodule.simple.constant;

public enum ModuleEnum {

    A("A", "模块A的作用"),
    B("A", "模块B的作用"),
    C("A", "模块C的作用"),
    ;

    private String key;

    private String desc;

    public String getKey() {
        return key;
    }

    public String getDesc() {
        return desc;
    }

    ModuleEnum(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }
}
