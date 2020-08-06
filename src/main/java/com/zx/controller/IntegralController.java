package com.zx.controller;

import java.util.Set;

import com.zx.constant.RedisKeyConstants;
import com.zx.model.User;
import com.zx.service.UserService;
import com.zx.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouxuan
 * @date 2020/8/5 17:02
 */
@RestController
public class IntegralController {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private UserService userService;

    /**
     * 获取前10
     * @return
     */
    @GetMapping("getTopTen")
    public Set<ZSetOperations.TypedTuple<String>> top10() {
        return redisUtils.zResverseRangeWithScore(RedisKeyConstants.INTEGRAL_SORT_KEY, 1, 10);
    }

    /**
     * 遗留问题：分数相同的话根据什么排序
     * @return
     */
    @GetMapping("getRank")
    public Long getRank() {
        String userId = "556358";
        //如果在缓存中不存在
        if (!redisUtils.isMember(RedisKeyConstants.INTEGRAL_SORT_KEY, userId)) {
            //从数据库查询 存放到缓存中
            User user = userService.selectByUserId(userId);
            redisUtils.zadd(RedisKeyConstants.INTEGRAL_SORT_KEY, userId, user.getScore());
        }
        return redisUtils.zResverseRank(RedisKeyConstants.INTEGRAL_SORT_KEY, "") + 1;
    }
}
