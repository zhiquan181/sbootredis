package com.zhiquan.cai.sbootredis.service;

import java.util.List;

public interface RedisService {

     //设置字符串变量到redis
     boolean set(String key, String value) throws Exception;

     //从redis获取字符串变量
     String get(String key) throws Exception;

     //从redis删除字符串变量
     void del(String key) throws Exception;

     //从redis使字符串变量失效
     boolean expire(String key, long expire) throws Exception;

     //设置集合到redis
     <T> boolean setList(String key, List<T> list) throws Exception;

     //从redis获取集合
     <T> List<T> getList(String key, Class<T> clz) throws Exception;

     //Redis Lpush 命令将一个或多个值插入到列表头部。
     // 如果 key 不存在，一个空列表会被创建并执行 LPUSH 操作。 当 key 存在但不是列表类型时，返回一个错误。
     long lpush(String key, Object obj) throws Exception;

     //Redis Rpush 命令用于将一个或多个值插入到列表的尾部(最右边)。
     //如果列表不存在，一个空列表会被创建并执行 RPUSH 操作。 当列表存在但不是列表类型时，返回一个错误。
     long rpush(String key, Object obj) throws Exception;

     //Redis Hmset 命令用于同时将多个 field-value (字段-值)对设置到哈希表中。
     //此命令会覆盖哈希表中已存在的字段。
     //如果哈希表不存在，会创建一个空哈希表，并执行 HMSET 操作。
     void hmset(String key, Object obj) throws Exception;

     //Redis Hget 命令用于返回哈希表中指定字段的值。
     <T> T hget(String key, Class<T> clz) throws Exception;

     //Redis Hget 命令用于返回哈希表中指定字段的值。
     // 返回List类型
     <T> List<T>  hmGetAll(String key, Class<T> clz) throws Exception;

     //Redis Lpop 命令用于移除并返回列表的第一个元素。
     String lpop(String key) throws Exception;
}
