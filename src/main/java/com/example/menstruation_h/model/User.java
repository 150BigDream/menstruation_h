package com.example.menstruation_h.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zz
 * @since 2020-05-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户注册ID
     */
    @TableId(value = "userID", type = IdType.AUTO)
    private Integer userID;

    /**
     * 例假持续时间
     */
    @TableField("sustainDay")
    private Integer sustainDay;

    /**
     * 间隔多少天来一次
     */
    @TableField("intervalDay")
    private Integer intervalDay;

    @TableField("fsustainDay")
    private Integer fsustainDay;

    @TableField("fintervalDay")
    private Integer fintervalDay;

    @TableField("openID")
    private String openID;
}
