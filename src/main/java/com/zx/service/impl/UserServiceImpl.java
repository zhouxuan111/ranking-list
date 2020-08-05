package com.zx.service.impl;

import com.zx.constant.RedisKeyConstants;
import com.zx.service.UserService;
import com.zx.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhouxuan
 * @date 2020/8/5 17:02
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public boolean zAddScore(String userId, double score) {
        return redisUtils.zadd(RedisKeyConstants.INTEGRAL_SORT_KEY, userId, score);
    }

    @Override
    public void zRemove(String userId) {
        redisUtils.zRemove(RedisKeyConstants.INTEGRAL_SORT_KEY, new String[] {userId});
    }

    @Override
    public boolean zUpdate(String userId, double delta) {
        return redisUtils.zadd(RedisKeyConstants.INTEGRAL_SORT_KEY, userId, delta);
    }
}
