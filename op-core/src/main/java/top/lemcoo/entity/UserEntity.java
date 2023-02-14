package top.lemcoo.entity;

import cn.hutool.core.collection.CollUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 用户实体
 *
 * @author zhaowx
 * @date 2023-02-12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements Serializable {

    private String id;

    private String username;

    private String password;

    private String role;

    /**
     * 获取用户列表
     *
     * @return {@code List<UserEntity>}
     */
    public static List<UserEntity> getUserList() {
        return CollUtil.newArrayList(
                new UserEntity("1", "轩同欢", "123456", "admin"),
                new UserEntity("2", "张梦哲", "123456", "superAdmin")
        );
    }
}
