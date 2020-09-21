package com.mingbyte.pojo.dto;

import lombok.Data;


/**
 * @author M
 * @since 2020/9/16 16:30
 */
@Data
public class RegisterDto {

    /**
     * 手机号
     */
    private String tel;

    /**
     * 密码
     */
    private String password;

    /**
     * 名称
     */
    private String adminName;
}
