package com.dxc.questionary.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dxc.questionary.entity.TableDAO;
import com.dxc.questionary.mapper.TableMapper;
import com.dxc.questionary.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author huang
 */
@Service
public class TableServiceImpl implements TableService {
    @Autowired
    TableMapper tableMapper;

    @Override
    public void add(TableDAO tableDAO) {
        tableMapper.insert(tableDAO);
    }

    @Override
    public Page<TableDAO> page(Page<TableDAO> page) {
        return tableMapper.page(page);
    }

    @Override
    public List<TableDAO> selectAll() {
        return tableMapper.selectList(null);
    }

    @Override
    public IPage<TableDAO> find(String city, Date start, Date end, IPage<TableDAO> page) {
        return tableMapper.find(city, start, end, page);
    }
}
