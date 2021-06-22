package com.liuxinchi.demo2;

public class UserServiceProxy {
    private UserServiceImpl uservice;

    public UserServiceImpl getUservice() {
        return uservice;
    }

    public void setUservice(UserServiceImpl uservice) {
        this.uservice = uservice;
    }

    public void log(String msg){
        System.out.println("使用了"+msg+"方法");
    }

    public void add(){
        log("add");
        uservice.add();
    }

    public void delet(){
        log("delet");
        uservice.delet();
    }

    public void qurey(){
        log("qurey");
        uservice.qurey();
    }

    public void upadate(){
        log("upadate");
        uservice.add();
    }
    
}
