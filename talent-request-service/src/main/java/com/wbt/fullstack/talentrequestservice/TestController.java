package com.wbt.fullstack.talentrequestservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/api/test"})
public class TestController {

    @Value("${spring.application.name}")
    private String serviceName;

    private final Environment env;

    public TestController(Environment env) {
        this.env = env;
    }

    @GetMapping
    public String getTest() {
        return "Test from %s:%s".formatted(serviceName, env.getProperty("local.server.port"));
    }
}
