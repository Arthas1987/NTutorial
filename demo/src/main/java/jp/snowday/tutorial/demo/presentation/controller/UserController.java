package jp.snowday.tutorial.demo.presentation.controller;

import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    @GetMapping("/test")
    public String test() {
        return "Hello World!";
    }
}
