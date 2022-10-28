package com.dxc.questionary.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dxc.questionary.entity.TableDAO;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author huang
 */
@Service
public interface TableService {
    // 新增数据
    void add(TableDAO tableDAO);

    // 分页查询
    Page<TableDAO> page(Page<TableDAO> page);

    List<TableDAO> selectAll();

    IPage<TableDAO> find(String city, Date start, Date end, IPage<TableDAO> page);
}
