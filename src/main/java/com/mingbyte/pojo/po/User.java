package com.mingbyte.pojo.po;

import com.baomidou.mybatisplus.annotation.*;
import com.mingbyte.enums.DeleteStatus;
import lombok.Data;

/**
 * @author M
 * @since 2020/9/15 13:40
 */
@Data
@TableName("t_user")
public class User {

    @TableId(type = IdType.ID_WORKER)
    private Long id;

    @TableField(value = "user_name"/*,updateStrategy = FieldStrategy.IGNORED*/)
    private String userName;

    @TableField("age")
    private Integer age;

    @TableField("is_delete")
    private DeleteStatus isDelete;
}
