package com.NeuroActivity.letswrite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class MainController {
    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/app")
    public String app(){
        return "app";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }
}
