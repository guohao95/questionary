package com.dxc.questionary.service;

import com.dxc.questionary.entity.TextVO;
import org.springframework.stereotype.Service;

/**
 * @author huang
 */
@Service
public interface TextService {
    String getText(String type);

    void updateText(TextVO t);
}
