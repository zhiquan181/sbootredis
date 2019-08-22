package com.zhiquan.cai.sbootredis.vi;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 当我们需要用到分页查询的时候，我们定义的接口需要继承PagingAndSortingRepository接口来实现分页
 *
 * 该接口提供了分页与排序功能   
 *  --Iterable<T> findAll(Sort sort); //排序    
 *
 * --Page<T> findAll(Pageable pageable); //分页查询（含排序功能）
 */
public interface UserInfoRepository extends PagingAndSortingRepository<UserInfo, String> {
    //根据id查找用户
    UserInfo findOneById(String id);
}
