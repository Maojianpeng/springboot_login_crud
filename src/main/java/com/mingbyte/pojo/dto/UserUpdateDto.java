package com.mingbyte.pojo.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;


/**
 * @author M
 * @since 2020/9/16 17:27
 */
@Data
public class UserUpdateDto {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String userName;

    private Integer age;
}
