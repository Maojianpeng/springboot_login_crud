package com.mingbyte.pojo.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @author M
 * @since 2020/9/15 14:19
 */
@Data
public class LoginDto {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String tel;

    private String password;
}
