package com.dxc.questionary.utils;


import cn.hutool.jwt.JWTUtil;
import com.dxc.questionary.config.constant.Constant;
import com.dxc.questionary.entity.TokenVO;

import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    // 创建token
    public static TokenVO CreateToken(String username) {
        Long expireTime = System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7;
        Map<String, Object> map = new HashMap<>() {
            private static final long serialVersionUID = 1L;

            {
                put("username", username);
                put("expire_time", expireTime);
            }
        };
        return new TokenVO(JWTUtil.createToken(map, Constant.TOKEN_SECRET.getBytes()), expireTime);
    }

    // 验证token
    public static boolean tokenVerify(String token) {
        if (!JwtUtil.isNull(token)) {
            return JWTUtil.verify(token, Constant.TOKEN_SECRET.getBytes());
        }
        return false;
    }

    // 判空
    public static boolean isNull(String str) {
        if ("".equals(str) || str == null) {
            return true;
        }
        return false;
    }
}
