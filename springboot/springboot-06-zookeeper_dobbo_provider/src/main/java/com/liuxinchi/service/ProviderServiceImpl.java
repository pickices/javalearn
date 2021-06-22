package com.liuxinchi.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@DubboService
@Service
public class ProviderServiceImpl implements ProviderService {

    public String provider(){
        return "这里是提供者";
    }

}
