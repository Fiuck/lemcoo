package top.lemcoo.springpractise.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import top.lemcoo.entity.UserEntity;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("trace")
    public String trace(@RequestBody UserEntity userEntity) {
        log.info("中间打印：{}", userEntity.getId());
        return userEntity + ":return";
    }
}
