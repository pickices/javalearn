package com.liuxinchi.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {
    @Value("liuxinchi")
    public String name;
}
