package com.zx.service.impl;

import java.util.Date;

import com.zx.constant.RedisKeyConstants;
import com.zx.model.User;
import com.zx.service.UserService;
import com.zx.util.RedisUtils;
import com.zx.util.ScoreUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhouxuan
 * @date 2020/8/6 9:49
 */
@Service
public class UserServiceImpl implements UserService {
/*
    @Resource
    private UserDao userDao;*/

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public void add(User user) {
        // userDao.add(user);
        //加入缓存
        if (!user.getScore().equals(0)) {
            double score = ScoreUtil.getScore(user.getScore(), new Date());
            redisUtils.zadd(RedisKeyConstants.INTEGRAL_SORT_KEY, user.getUserId(), score);
        }
    }

    @Override
    public void delete(User user) {
        //userDao.delete(user);
        redisUtils.zRemove(RedisKeyConstants.INTEGRAL_SORT_KEY, user.getUserId());
    }

    @Override
    public void update(User user) {
        // userDao.update(user);
        //不存在直接新增，若存在直接根据userId和key更新
        redisUtils.zadd(RedisKeyConstants.INTEGRAL_SORT_KEY, user.getUserId(),
                ScoreUtil.getScore(user.getScore(), new Date()));

    }

    @Override
    public User selectByUserId(String userId) {
       /* if (userId == null) {
            return null;
        }
        return userDao.selectByUserId(userId);*/
        return null;
    }
}
