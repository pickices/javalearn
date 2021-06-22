package com.liuxinchi;

import com.liuxinchi.service.ConsumerService;
import com.liuxinchi.service.ConsumerServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot06ZookeeperDobboConsumerApplicationTests {

    @Autowired
    ConsumerServiceImpl consumerService;

    @Test
    void contextLoads() {
        consumerService.test();
    }

}
