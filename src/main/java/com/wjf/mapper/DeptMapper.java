package com.wjf.mapper;

import com.wjf.entity.Dept;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptMapper {
    Dept getById(Integer id);
}
