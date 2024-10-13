package com.example.use.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "test";
    }

    @RequestMapping("test1")
    public String test1(HttpServeletRequest httpServletRequest , Model model) {
        String id = httpServletRequest.getParameter("id");
        String name= httpServletRequest.getParameter("name");

        model.addAttribute("id", id);
        model.addAttribute("name", name);
        return "test1";
    }

    @RequestMapping("test2")
    public String test2(@RequestParam("id") String id, @RequestParam("name") String name,Model model){
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        return "test2";

    }

    @RequestMapping("test3")
    public String test3(Member member, Model model){ // Member DTO 가 존재 할 때 ,
        return "test3";
    }

    // path 에 param을 직접박기
    @RequestMapping("test4/{studentId}/{name}")
    public String test4(@PathVariable String studentId, @PathVariable String name, Model model){
        model.addAttribute("id" , studentId);
        model.addAttribute("name", name);
        return "test4";
    }

}
