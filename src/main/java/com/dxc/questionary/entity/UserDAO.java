package com.dxc.questionary.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author huang
 */
@Data
public class UserDAO {
    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "占位符")
    private String temp;
}
