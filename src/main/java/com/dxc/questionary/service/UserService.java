package com.dxc.questionary.service;

import com.dxc.questionary.entity.TokenVO;
import org.springframework.stereotype.Service;

/**
 * @author huang
 */
@Service
public interface UserService {
    // 登录
    TokenVO login(String username, String password);

    // 修改密码
    boolean resetPassword(String username, String password);
}
