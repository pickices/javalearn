package com.liuxinchi.demo3;

public class Host implements Rent {
    public void rent(){
        System.out.println("房东要出租房子！");
    }

    @Override
    public Rent getProxy() {
        return null;
    }

}
