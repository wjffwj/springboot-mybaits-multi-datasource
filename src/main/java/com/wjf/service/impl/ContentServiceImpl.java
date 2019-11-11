package com.wjf.service.impl;

import com.wjf.entity.Content;

import com.wjf.mapper.ContentMapper;
import com.wjf.service.IContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author weijunfeng
 * @since 2019-05-20
 */
@Service
public class ContentServiceImpl  implements IContentService {
    @Autowired
    private ContentMapper contentMapper;


    public List<Content> getOne(){
        return contentMapper.getOne();
    }
}
