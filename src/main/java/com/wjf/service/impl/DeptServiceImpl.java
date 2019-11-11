package com.wjf.service.impl;

import com.wjf.entity.Dept;
import com.wjf.mapper.DeptMapper;
import com.wjf.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @created by 24745
 * @date 2019/11/11
 */
@Service
public class DeptServiceImpl implements IDeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }
}
