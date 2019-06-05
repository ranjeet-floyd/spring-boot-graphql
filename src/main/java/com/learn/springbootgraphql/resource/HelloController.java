package com.learn.springbootgraphql.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class HelloController {

    @Value("${message}")
    private String message;

    @Value("${hello.message}")
    private String helloMessage;

    @GetMapping
    public String hello() {
        return message + "\t" + helloMessage;
    }

}
