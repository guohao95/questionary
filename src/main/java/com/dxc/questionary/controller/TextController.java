package com.dxc.questionary.controller;

import com.dxc.questionary.config.JSONResult;
import com.dxc.questionary.config.constant.Constant;
import com.dxc.questionary.entity.TableDAO;
import com.dxc.questionary.entity.TextDAO;
import com.dxc.questionary.entity.TextVO;
import com.dxc.questionary.service.TextService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author huang
 */
@RestController
@Validated
@RequestMapping("/text")
@Api(tags = "章程集合")
@CrossOrigin(originPatterns = "*")
public class TextController {

    @Autowired
    TextService textService;

    @PostMapping("/update")
    @ApiOperation(value = "新增章程")
    public JSONResult save(@RequestBody TextVO text) {
        textService.updateText(text.getText());
        return JSONResult.OK();
    }

    @GetMapping("/get")
    @ApiOperation(value = "查询章程")
    public JSONResult get() {
        return JSONResult.Ok(Constant.OPERATION_SUCCESS, textService.getText());
    }
}
