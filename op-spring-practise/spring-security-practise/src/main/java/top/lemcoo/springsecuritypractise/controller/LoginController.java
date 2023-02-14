package top.lemcoo.springsecuritypractise.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lemcoo.api.R;
import top.lemcoo.entity.UserEntity;
import top.lemcoo.springsecuritypractise.service.ILoginService;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {

    private final ILoginService loginService;

    @PostMapping
    public R<String> login(@RequestBody UserEntity userEntity) {
        return R.data(loginService.login(userEntity));
    }
}
