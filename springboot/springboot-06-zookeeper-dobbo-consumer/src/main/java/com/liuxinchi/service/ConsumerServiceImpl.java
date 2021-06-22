package com.liuxinchi.service;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @DubboReference
    public ProviderService providerService;
    public void test(){
        String s = providerService.provider();
        System.out.println(s+"========这里是消费者");
    }

}
