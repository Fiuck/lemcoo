package top.lemcoo.springsecuritypractise.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.lemcoo.api.R;
import top.lemcoo.entity.UserEntity;
import top.lemcoo.springsecuritypractise.service.IUserService;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final IUserService userService;

    /**
     * 用户
     *
     * @param username 用户名
     * @return {@code R<UserEntity>}
     */
    @GetMapping
    public R<UserEntity> user(@RequestParam("username") String username) {
        return R.data(userService.getUser(username));
    }
}
