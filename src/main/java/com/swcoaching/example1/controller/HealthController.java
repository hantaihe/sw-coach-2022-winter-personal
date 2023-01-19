package com.swcoaching.example1.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping
public class HealthController {

    @GetMapping("/health")
    public String getHello() {
        return "health";
    }
}
