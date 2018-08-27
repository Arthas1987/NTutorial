package jp.snowday.tutorial.demo.presentation.controller;

import org.springframework.web.bind.annotation.*;

/**
 * テスト用のController
 * @author zhangnan
 * @date 2018/08/26
 */
@RestController
public class UserController {
    @GetMapping("/test")
    public String test() {
        return "Hello World!";
    }
}
