package com.dxc.questionary.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dxc.questionary.config.JSONResult;
import com.dxc.questionary.config.constant.Constant;
import com.dxc.questionary.entity.TableDAO;
import com.dxc.questionary.service.TableService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author huang
 */
@RestController
@Validated
@RequestMapping("/table")
@Api(tags = "表格集合")
@CrossOrigin(originPatterns = "*")
public class TableController {
    @Autowired
    TableService tableService;

    @GetMapping("/pages")
    @ApiOperation(value = "表单分页查询")
    public JSONResult<Page<TableDAO>> page(@RequestParam @ApiParam(value = "页面大小", name = "pageSize") Integer pageSize, @RequestParam @ApiParam(value = "当前页面", name = "pageIndex") Integer pageIndex) {
        Page<TableDAO> page = new Page<>(pageIndex, pageSize);
        return JSONResult.Ok(Constant.OPERATION_SUCCESS, tableService.page(page));
    }

    @PostMapping("/add")
    @ApiOperation(value = "新增数据")
    public JSONResult add(@RequestBody @Validated TableDAO tableDAO) {
        tableService.add(tableDAO);
        return JSONResult.OK();
    }

    @PostMapping("/export")
    @ApiOperation(value = "数据Excel导出")
    public void export(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("UTF-8");
        String fileName = URLEncoder.encode("信息导出表" + System.currentTimeMillis(), "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        List<TableDAO> data = new ArrayList<>();
        data = tableService.selectAll();
        EasyExcel.write(response.getOutputStream(), TableDAO.class).sheet("sheet1").doWrite(data);
    }

    @GetMapping("/find")
    @ApiOperation(value = "模糊查询")
    public JSONResult<IPage<TableDAO>> find(@RequestParam @ApiParam(value = "页面大小", name = "pageSize") Integer pageSize,
                                            @RequestParam @ApiParam(value = "当前页面", name = "pageIndex") Integer pageIndex,
                                            @RequestParam(required = false) @ApiParam(value = "城市名字", name = "city") String city,
                                            @RequestParam(required = false) @ApiParam(value = "起始时间", name = "start") String start,
                                            @RequestParam(required = false) @ApiParam(value = "终止时间", name = "end") String end) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date s = null, e = null;
        if (start != null && end != null) {
            s = simpleDateFormat.parse(start);
            e = simpleDateFormat.parse(end);
        }
        IPage<TableDAO> page = new Page<>(pageIndex, pageSize);
        return JSONResult.Ok(Constant.OPERATION_SUCCESS, tableService.find(city, s, e, page));
    }
}
