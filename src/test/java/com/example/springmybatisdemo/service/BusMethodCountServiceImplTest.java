package com.example.springmybatisdemo.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class BusMethodCountServiceImplTest {
    private BusMethodCountService service;

    @Autowired
    public BusMethodCountServiceImplTest(BusMethodCountService service) {
        this.service = service;
    }
    @Test
    void getBeans() {
        service.getBeans();
    }
}