package com.example.menstruation_h.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author zz
 * @since 2020-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Time implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("startTime")
    private LocalDate startTime;

    @TableField("endTime")
    private LocalDate endTime;

    @TableField("userID")
    private Integer userID;


}
