package com.wjf.controller;



import com.wjf.entity.Content;
import com.wjf.service.IContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author weijunfeng
 * @since 2019-05-20
 */
@RestController
@RequestMapping("/content")
public class ContentController {
    @Autowired
    private IContentService contentService;

    @RequestMapping(value = "/ok")
    public List<Content> getOk() {
        List<Content> one = contentService.getOne();

        System.out.println(1);
        return one;
    }

}

