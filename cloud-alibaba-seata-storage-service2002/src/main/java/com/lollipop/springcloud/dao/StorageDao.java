package com.lollipop.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: J.K
 * @Date: 2021-10-22 10:15
 * @Description:
 */
@Mapper
public interface StorageDao {
    void decrease(@Param("productId") Long productId,@Param("count") Integer count);
}
