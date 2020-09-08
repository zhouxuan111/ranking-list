package com.zx.controller;

import com.zx.model.User;
import com.zx.service.UserService;
import com.zx.util.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserService userService;

    @GetMapping("init")
    public void init() {

        for (int i = 0; i < 10000; i++) {
            User user = new User();
            user.setName("test" + i);
            user.setUserId("12341" + i);
            user.setScore(10 + 1 + i);
            userService.add(user);
        }
        /*Set<ZSetOperations.TypedTuple> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            String userId = RandomStringUtils.randomNumeric(6);
            Double score = Double.valueOf(RandomUtils.nextInt(0, 20));
            ZSetOperations.TypedTuple typedTuple = new DefaultTypedTuple(userId, score);
            set.add(typedTuple);
        }

        redisUtils.zadd(RedisKeyConstants.INTEGRAL_SORT_KEY, set);*/
    }

    @GetMapping("testTimeOut")
    public void testTimeOut() {
    }
}
