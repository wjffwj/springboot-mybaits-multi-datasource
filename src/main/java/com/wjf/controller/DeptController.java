package com.wjf.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.wjf.entity.Dept;
import com.wjf.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @created by 24745
 * @date 2019/11/11
 */
@RestController
@RequestMapping(value = "/dept")
public class DeptController {
    @Autowired
    private IDeptService deptService;
    @RequestMapping(value = "/get")
    public String getDeptById() {
        Integer id = 1;
        Dept dept = deptService.getById(id);
        Dept dept1 = deptService.getById1(id);
        System.out.println(JSON.toJSONString(dept));
        System.out.println(JSON.toJSONString(dept1));
        return JSON.toJSONString(dept);
    }
}
