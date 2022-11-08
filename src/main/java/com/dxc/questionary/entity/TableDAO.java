package com.dxc.questionary.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author huang
 */
@Data
@Valid
@TableName("questionary_table")
public class TableDAO {
    @ExcelProperty(value = "编号", order = 1)
    @ApiModelProperty(value = "编号", required = false)
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ColumnWidth(20)
    private Long id;

    @ExcelProperty(value = "单位名称", order = 2)
    @ApiModelProperty(value = "单位名称", required = true)
    @NotBlank(message = "单位名称不能为空")
    @ColumnWidth(25)
    private String agencyName;

    @ExcelProperty(value = "申请本协会职位", order = 3)
    @ApiModelProperty(value = "申请本协会职位", required = true)
    @NotBlank(message = "申请本协会职位不能为空")
    @ColumnWidth(25)
    private String applyPosition;

    @ExcelProperty(value = "单位类别", order = 4)
    @ApiModelProperty(value = "单位类别", required = true)
    @NotBlank(message = "单位类别不能为空")
    @ColumnWidth(25)
    private String agencyClass;

    @ExcelProperty(value = "单位地址", order = 5)
    @ApiModelProperty(value = "单位地址", required = true)
    @NotBlank(message = "单位地址不能为空")
    @ColumnWidth(25)
    private String agencyAddress;

    @ExcelProperty(value = "详细地址", order = 6)
    @ApiModelProperty(value = "详细地址", required = true)
    @NotBlank(message = "详细地址不能为空")
    @ColumnWidth(25)
    private String detailAddress;

    @ExcelProperty(value = "统一社会信用代码", order = 7)
    @ApiModelProperty(value = "统一社会信用代码", required = true)
    @ColumnWidth(25)
    private String uniteSocialCreditCode;

    @ExcelProperty(value = "注册资本", order = 8)
    @ApiModelProperty(value = "注册资本", required = true)
    @ColumnWidth(25)
    private String registeredCaptial;

    @ExcelProperty(value = "法定代表人", order = 9)
    @ApiModelProperty(value = "法定代表人", required = true)
    @NotBlank(message = "法定代表人不能为空")
    @ColumnWidth(25)
    private String artificialPerson;

    @ExcelProperty(value = "法人联系电话", order = 10)
    @ApiModelProperty(value = "法人联系电话", required = true)
    @ColumnWidth(25)
    private String phone;

    @ExcelProperty(value = "上半年主营业收入（万元）", order = 11)
    @ApiModelProperty(value = "上半年主营业收入（万元）", required = true)
    @ColumnWidth(25)
    private String halfIncome;

    @ExcelProperty(value = "上年末总资产（万元）", order = 12)
    @ApiModelProperty(value = "上年末总资产（万元）", required = true)
    @ColumnWidth(25)
    private String lastYearProperty;

    @ExcelProperty(value = "上年度纳税总额（万元）", order = 12)
    @ApiModelProperty(value = "上年度纳税总额（万元）", required = true)
    @ColumnWidth(25)
    private String lastYearTarrifyProperty;

    @ExcelProperty(value = "职工人数", order = 13)
    @ApiModelProperty(value = "职工人数", required = true)
    @ColumnWidth(25)
    private String employeeNumber;

    @ExcelProperty(value = "注册类型", order = 14)
    @ApiModelProperty(value = "注册类型", required = true)
    @NotBlank(message = "注册类别不能为空")
    @ColumnWidth(25)
    private String registerType;

    @ExcelProperty(value = "单位联系人", order = 15)
    @ApiModelProperty(value = "单位联系人", required = true)
    @NotBlank(message = "单位联系人不能为空")
    @ColumnWidth(25)
    private String agencyLinkMan;

    @ExcelProperty(value = "单位联系人电话", order = 16)
    @ApiModelProperty(value = "单位联系人电话", required = true)
    @NotBlank(message = "单位联系人电话不能为空")
    @ColumnWidth(25)
    private String agencyLinkManPhone;

    @ExcelProperty(value = "单位联系人职务", order = 17)
    @ApiModelProperty(value = "单位联系人职务", required = true)
    @NotBlank(message = "单位联系人职务不能为空")
    @ColumnWidth(25)
    private String agencyLinkManPosition;

    @ExcelProperty(value = "单位联系人电子邮箱", order = 18)
    @ApiModelProperty(value = "单位联系人电子邮箱", required = true)
    @Email(message = "单位联系人电子邮箱格式错误")
    @ColumnWidth(25)
    private String agencyLinkManEmail;

    @ExcelProperty(value = "单位简介", order = 19)
    @ApiModelProperty(value = "单位简介", required = true)
    @ColumnWidth(25)
    private String agencyProfile;

    @ExcelProperty(value = "创建时间", order = 20)
    @ApiModelProperty(value = "创建时间", required = true)
    @ColumnWidth(25)
    private String createdTime;
}
