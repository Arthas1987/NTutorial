package jp.snowday.tutorial.demo.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangnan
 * @date 2018/08/26
 */
@Controller
@RestController
public class ErrorController {
    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "Denied";
    }
}
