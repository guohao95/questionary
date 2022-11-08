package com.dxc.questionary.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dxc.questionary.entity.TextDAO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author huang
 */
@Mapper
public interface TextMapper extends BaseMapper<TextDAO> {
    @Select("select text from questionary_text")
    String getText();

    @Update("update questionary_text set text = #{str} where id = 1 ")
    void setText(String str);
}
