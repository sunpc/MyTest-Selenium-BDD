package com.sunpc.mytest.runner;

import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest
public class CucumberSpringConfiguration {

    @Before
    public void setupCucumberSpringContext() {

    }
}
