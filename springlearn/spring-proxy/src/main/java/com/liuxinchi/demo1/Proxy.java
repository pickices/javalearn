package com.liuxinchi.demo1;

public class Proxy {
    private Host host;

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public Proxy(Host host) {
        this.host = host;
    }

    public void rent(){
        host.rent();
    }
}
