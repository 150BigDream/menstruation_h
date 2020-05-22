package com.example.menstruation_h.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

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
public class Remind implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("userID")
    private Integer userID;

    private LocalDateTime start;

    private LocalDateTime end;

    @TableField("drinkWater")
    private Integer drinkWater;

    private Integer exercise;

    @TableField("earlyToBed")
    private Integer earlyToBed;

    @TableField("eatBreakfast")
    private Integer eatBreakfast;

    private Integer reading;


}
