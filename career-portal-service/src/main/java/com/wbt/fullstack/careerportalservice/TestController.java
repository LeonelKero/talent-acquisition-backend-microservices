package com.wbt.fullstack.careerportalservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/careers"})
public class TestController {

    private final Environment env;

    @Value("${spring.application.name}")
    private String serviceName;

    public TestController(Environment env) {
        this.env = env;
    }

    @GetMapping
    public String getTest() {
        return "Test from %s:%s".formatted(serviceName, env.getProperty("server.port"));
    }
}
