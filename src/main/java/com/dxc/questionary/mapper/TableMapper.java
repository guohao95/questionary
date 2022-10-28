package com.dxc.questionary.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dxc.questionary.entity.TableDAO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * @author huang
 */
@Mapper
public interface TableMapper extends BaseMapper<TableDAO> {
    @Select("select * from `questionary_table`")
    Page<TableDAO> page(Page<TableDAO> page);

    IPage<TableDAO> find(String city, Date start, Date end, IPage<TableDAO> page);
}
