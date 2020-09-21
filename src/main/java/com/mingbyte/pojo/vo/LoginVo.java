package com.mingbyte.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @author M
 * @since 2020/9/15 14:08
 */
@Data
public class LoginVo {
    /**
     * 当前登录用户主键id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;


    /**
     * 手机号
     */
    private String tel;

    /**
     * 管理员姓名
     */
    private String admin_name;


    /**
     * jwt token(用于接口访问认证)
     */
    private String token;
}
