package com.zx.controller;

import java.util.HashSet;
import java.util.Set;

import com.zx.constant.RedisKeyConstants;
import com.zx.util.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouxuan
 * @date 2020/8/5 18:05
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    private RedisUtils redisUtils;

    @GetMapping("init")
    public void init() {
        Set<ZSetOperations.TypedTuple> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            String userId = RandomStringUtils.randomNumeric(6);
            Double score = Double.valueOf(RandomUtils.nextInt(0, 20));
            ZSetOperations.TypedTuple typedTuple = new DefaultTypedTuple(userId, score);
            set.add(typedTuple);
        }

        redisUtils.zadd(RedisKeyConstants.INTEGRAL_SORT_KEY, set);
    }
}
