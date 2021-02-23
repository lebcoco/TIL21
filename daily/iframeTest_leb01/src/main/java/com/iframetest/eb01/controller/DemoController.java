package com.iframetest.eb01.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @CrossOrigin(origins = "http://iframeTestEB")
    @GetMapping("/")
    public String index() {
        return "http://182.252.135.30:180/";
    }
}

