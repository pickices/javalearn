package com.liuxinchi.demo3;

public class Client {
    public static void main(String[] args) {

        Host host = new Host();
        ProxyInvocationHandler pid = new ProxyInvocationHandler();
        pid.setRent(host);
        Rent proxy = (Rent)pid.getProxy();
        proxy.rent();
        
    }
}
