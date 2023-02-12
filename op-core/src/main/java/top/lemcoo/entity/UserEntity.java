package top.lemcoo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户实体
 *
 * @author zhaowx
 * @date 2023-02-12
 */
@Data
public class UserEntity implements Serializable {

    private String id;

    private String name;

    private String password;
}
