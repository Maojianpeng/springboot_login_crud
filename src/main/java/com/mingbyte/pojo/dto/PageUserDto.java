package com.mingbyte.pojo.dto;

import com.mingbyte.enums.DeleteStatus;
import lombok.Data;

/**
 * @author M
 * @since 2020/9/17 13:20
 */
@Data
public class PageUserDto {

    private String userName;

    private String age;

    private DeleteStatus isDelete;
}
