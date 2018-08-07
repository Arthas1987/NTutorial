package jp.snowday.tutorial.demo.controller;

import jp.snowday.tutorial.demo.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

        @GetMapping(path = "user/{id}")
        public User getUser(@PathVariable String id) {
            return new User();
        }


        @PostMapping(path = "user")
        @ResponseStatus(HttpStatus.CREATED)
        public void createUser(final @Valid @RequestBody User user, final BindingResult bindingResult) {
        }

        @PutMapping(path = "user/{id}")
        @ResponseStatus(HttpStatus.CREATED)
        public void updateUser(@PathVariable String id, @Valid @RequestBody User user,
                               final BindingResult bindingResult) {
        }

        @DeleteMapping(path = "user/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteUser(@PathVariable String id) {
        }
}
