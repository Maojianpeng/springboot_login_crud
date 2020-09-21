package com.mingbyte.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;

/**
 * @author M
 * @since 2020/9/1 14:08
 */
@ApiModel(description = "是否逻辑删除标识")
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum DeleteStatus {


    DELETE(0, "删除"),


    NORMAL(1, "正常"),
    ;


    /**
     * 代码
     */
    @EnumValue
    private final int code;

    /**
     * 内容
     */
    private final String msg;


    /**
     * @param code 代码
     * @param msg  内容
     */
    DeleteStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return msg;
    }


    /**
     * 根据代码获取枚举
     * 不要尝试缓存全部的枚举，该方法用到的频率不会太高，且枚举很少，不会造成资源浪费
     * <p>
     * 使用 @JsonCreator 让 jackson 解析 json 的时候能匹配到该枚举
     * 参考：https://segmentfault.com/q/1010000020636087
     *
     * @param code 枚举code
     * @return CertificationStatusEnum
     */
    @JsonCreator
    public static DeleteStatus getByCode(int code) {

        DeleteStatus[] values = DeleteStatus.values();

        for (DeleteStatus value : values) {
            if (value.getCode() == code) {
                return value;
            }
        }
        System.out.printf("枚举错误");
        return null;

    }
}
