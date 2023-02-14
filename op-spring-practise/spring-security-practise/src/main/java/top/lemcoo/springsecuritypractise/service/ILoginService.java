package top.lemcoo.springsecuritypractise.service;

import cn.hutool.core.codec.Base64Encoder;
import cn.hutool.core.lang.Opt;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.lemcoo.entity.UserEntity;
import top.lemcoo.exception.ServiceException;

@Slf4j
@Service
@AllArgsConstructor
public class ILoginService {

    private final IUserService userService;

    public String login(UserEntity userEntity) {
        if (StrUtil.isBlank(userEntity.getUsername()) || StrUtil.isBlank(userEntity.getPassword())) {
//            throw new ServiceException("用户名或密码错误");
            return null;
        }
        UserEntity user = userService.getUser(userEntity.getUsername());
        String password = Opt.ofNullable(user).map(UserEntity::getPassword).orElseThrow(ServiceException::new, "用户或密码错误");
        if (!StrUtil.equals(password, userEntity.getPassword())) {
//            throw new ServiceException("用户名或密码错误");
            return null;
        }
        return Base64Encoder.encode(JSONUtil.toJsonStr(user));
    }
}
