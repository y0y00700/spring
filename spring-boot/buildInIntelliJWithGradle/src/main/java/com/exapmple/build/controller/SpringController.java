package com.exapmple.build.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class SpringController {
    @RequestMapping("/")
    public String testJsp() {
        return "test";
    }
}
