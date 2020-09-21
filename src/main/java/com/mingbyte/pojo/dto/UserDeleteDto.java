package com.mingbyte.pojo.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.mingbyte.enums.DeleteStatus;
import lombok.Data;

/**
 * @author M
 * @since 2020/9/18 10:39
 */
@Data
public class UserDeleteDto {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String userName;

    private Integer age;

    private DeleteStatus isDelete;
}
