package com.my;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {
    @PostMapping("/user")
    public User postUser(@Valid @RequestBody User user, BindingResult bindingResult) {

//如果验证通不过的处理112222
        return null;

    }

}
