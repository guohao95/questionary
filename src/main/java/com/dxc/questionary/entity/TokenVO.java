package com.dxc.questionary.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenVO {
    @ApiModelProperty(value = "token")
    private String token;

    @ApiModelProperty(value = "过期时间")
    private Long expireTime;
}
