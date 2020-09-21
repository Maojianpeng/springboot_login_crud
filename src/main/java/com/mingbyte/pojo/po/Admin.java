package com.mingbyte.pojo.po;

import com.baomidou.mybatisplus.annotation.*;
import com.mingbyte.enums.DeleteStatus;
import lombok.Data;

/**
 * @author M
 * @since 2020/9/15 13:54
 */
@Data
@TableName("admin")
public class Admin {

    @TableId(type = IdType.ID_WORKER)
    private Long id;

    @TableField(value = "admin_name",updateStrategy = FieldStrategy.IGNORED)
    private String adminName;

    @TableField("password")
    private String password;

    @TableField("tel")
    private String tel;

    @TableField("is_delete")
    private DeleteStatus isDelete;
}
