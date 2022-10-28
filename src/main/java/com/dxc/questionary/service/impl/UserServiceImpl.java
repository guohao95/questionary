package com.dxc.questionary.service.impl;

import com.dxc.questionary.entity.TokenVO;
import com.dxc.questionary.mapper.UserMapper;
import com.dxc.questionary.service.UserService;
import com.dxc.questionary.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author huang
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public TokenVO login(String username, String password) {
        if (verifyPassword(username, password)) {
            return JwtUtil.CreateToken(username);
        }
        return null;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
    public boolean resetPassword(String username, String password) {
        if (!isExist(username)) {
            return false;
        }
        userMapper.resetPassword(username, password);
        return true;
    }

    private Boolean verifyPassword(String username, String password) {
        String pwd = userMapper.login(username);
        if (pwd.equals(password)) {
            return true;
        }
        return false;
    }

    private boolean isExist(String username) {
        if (userMapper.countUser(username) > 0) {
            return true;
        }
        return false;
    }
}
