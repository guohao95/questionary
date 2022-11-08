package com.dxc.questionary.service;

import org.springframework.stereotype.Service;

/**
 * @author huang
 */
@Service
public interface TextService {
    String getText();

    void updateText(String str);
}
