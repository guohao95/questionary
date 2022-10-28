package com.dxc.questionary.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author huang
 */
@Mapper
public interface UserMapper {
    @Select("select `password` from `questionary_user` where `username` = #{username}")
    String login(String username);

    @Select("update `questionary_user` set `password` = #{password} where `username` = #{username} or `phone`= #{username}")
    void resetPassword(String username, String password);

    @Select("select count(*) from `questionary_user` where `username` = #{username} or `phone` = #{username}")
    int countUser(String username);
}
