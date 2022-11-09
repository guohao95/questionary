package com.dxc.questionary.service.impl;

import com.dxc.questionary.config.constant.Constant;
import com.dxc.questionary.entity.TextVO;
import com.dxc.questionary.mapper.TextMapper;
import com.dxc.questionary.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huang
 */
@Service
public class TextServiceImpl implements TextService {
    @Autowired
    TextMapper textMapper;

    @Override
    public String getText(String t) {
        if (Constant.TEXT_TYPE.equals(t)) {
            return textMapper.getText();
        } else if (Constant.STRUCT_TYPE.equals(t)) {
            return textMapper.getStruct();
        } else {
            return null;
        }
    }

    @Override
    public void updateText(TextVO t) {
        if (Constant.TEXT_TYPE.equals(t.getType())) {
            textMapper.setText(t.getText());
        } else if (Constant.STRUCT_TYPE.equals(t.getType())) {
            textMapper.setStruct(t.getText());
        }
    }
}
