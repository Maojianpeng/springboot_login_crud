package com.mingbyte.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @author M
 * @since 2020/9/15 15:03
 */
@Data
public class AdminVo {

    /**
     * 当前登录用户主键id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Integer id;


    /**
     * 手机号
     */
    private String tel;

    /**
     * 管理员名字
     */
    private String adminName;


    /**
     * jwt token(用于接口访问认证)
     */
    private String token;
}
