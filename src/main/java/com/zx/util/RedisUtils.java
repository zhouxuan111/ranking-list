package com.zx.util;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

/**
 * redis工具类
 * @author zhouxuan
 * @date 2020/8/5 17:11
 */
@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate redisTemplate;

    /*------------针对zset(有序集合)数据类型的操作-----------*/

    /**
     * 新增
     * @param key
     * @param value
     * @param score
     * @return
     */
    public boolean zadd(String key, String value, double score) {

        return redisTemplate.opsForZSet().add(key, value, score);

    }

    /**
     * 批量新增
     * @param key
     * @param values
     * @return
     */
    public Long zadd(String key, Set<ZSetOperations.TypedTuple> values) {
        return redisTemplate.opsForZSet().add(key, values);
    }

    /**
     * 批量删除
     * @param key
     * @param values
     * @return
     */
    public void zRemove(String key, String... values) {
        redisTemplate.opsForZSet().remove(key, values);
    }

    /**
     * 增加元素的score值
     * @param key
     * @param value
     * @param delta
     * @return
     */
    public Double zIncrementScore(String key, String value, double delta) {
        return redisTemplate.opsForZSet().incrementScore(key, value, delta);
    }

    /**
     * 返回某一元素的排名值
     * @param key
     * @param value
     * @return 0表示一位
     */
    public Long zRank(String key, String value) {
        return redisTemplate.opsForZSet().rank(key, value);
    }

    public Long zResverseRank(String key, String value) {
        return redisTemplate.opsForZSet().reverseRank(key, value);
    }

    /**
     * 按照score由大到小排列
     * @param key
     * @param value
     * @return
     */
    public Long zResverRank(String key, String value) {
        return redisTemplate.opsForZSet().reverseRank(key, value);
    }

    /**
     * 获取集合的元素，从小到大
     * @param key
     * @param start ：开始位置
     * @param end ：结束位置 -1查询所有
     * @return 只返回value集合
     */
    public Set<String> zRange(String key, long start, long end) {
        return redisTemplate.opsForZSet().range(key, start, end);
    }

    /**
     * 获取元素的集合 包含score 由小到大
     * @param key
     * @param start：开始位置
     * @param end：结束位置 -1获取所有
     * @return
     */
    public Set<ZSetOperations.TypedTuple<String>> zRangeWithScore(String key, long start, long end) {
        return redisTemplate.opsForZSet().rangeWithScores(key, start, end);
    }

    /**
     * 获取集合的元素，从大到小
     * @param key
     * @param start ：开始位置
     * @param end ：结束位置 -1查询所有
     * @return 只返回value集合
     */
    public Set<String> zResverseRange(String key, long start, long end) {
        return redisTemplate.opsForZSet().reverseRange(key, start, end);
    }

    /**
     * 获取元素的集合 包含score 由大到小
     * @param key
     * @param start：开始位置
     * @param end：结束位置 -1获取所有
     * @return
     */
    public Set<ZSetOperations.TypedTuple<String>> zResverseRangeWithScore(String key, long start, long end) {
        return redisTemplate.opsForZSet().reverseRangeWithScores(key, start, end);
    }

    /**
     * 获取集合中某一元素的score
     * @param key
     * @param value
     * @return
     */
    public Double zScore(String key, String value) {
        return redisTemplate.opsForZSet().score(key, value);
    }

}
