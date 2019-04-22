package com.shemuel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("index")
    public String hello() {
        return "index";
    }
    @RequestMapping("*")
    public String error() {
        return "404";
    }
}
