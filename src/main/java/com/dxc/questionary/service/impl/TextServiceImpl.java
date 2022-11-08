package com.dxc.questionary.service.impl;

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
    public String getText() {
        return textMapper.getText();
    }

    @Override
    public void updateText(String str) {
        textMapper.setText(str);
    }
}
