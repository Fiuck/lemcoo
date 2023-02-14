package top.lemcoo.springsecuritypractise.service;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.lemcoo.entity.UserEntity;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class IUserService {

    /**
     * 获取用户
     *
     * @param username 用户名
     * @return {@code UserEntity}
     */
    public UserEntity getUser(String username) {
        List<UserEntity> userList = UserEntity.getUserList();
        return userList.stream().filter(i -> StrUtil.equals(username, i.getUsername())).findAny().orElse(null);
    }
}
