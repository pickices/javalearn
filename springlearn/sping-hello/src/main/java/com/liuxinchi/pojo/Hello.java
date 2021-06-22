package com.liuxinchi.pojo;

public class Hello {
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @override
    public String toString() {
        return "Hello{"+
                "str='"+str+'\\'+
                '}';
        
    }
}
