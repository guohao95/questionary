package com.dxc.questionary.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author huang
 */
@Data
@TableName(value = "questionary_text")
public class TextDAO {
    @ApiModelProperty(value = "id", required = false)
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "章程", required = true)
    @NotBlank(message = "章程不能为空")
    private String text;

    @ApiModelProperty(value = "创建时间", required = true)
    private String createdTime;
}
