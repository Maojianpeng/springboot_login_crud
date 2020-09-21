package com.mingbyte.pojo.vo;

import lombok.Data;

/**
 * @author M
 * @since 2020/9/16 14:23
 */
@Data
public class ResponseVo<T> {
    private int code;
    private String message;
    private T body;
}
