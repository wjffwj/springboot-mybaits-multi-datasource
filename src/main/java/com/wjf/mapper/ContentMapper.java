package com.wjf.mapper;

import com.wjf.entity.Content;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author weijunfeng
 * @since 2019-05-20
 */
@Repository
public interface ContentMapper {

    List<Content> getOne();
}
