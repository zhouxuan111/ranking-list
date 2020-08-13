package com.zx.service;

import com.zx.model.User;

/**
 * @author zhouxuan
 * @date 2020/8/6 9:49
 */
public interface UserService {

    /**
     * 新增
     * @param user
     */
    void add(User user);

    /**
     * 删除
     * @param user
     */
    void delete(User user);

    /**
     * 更新
     * @param user
     */
    void update(User user);

    /**
     * 根据userId查询
     * @param userId
     * @return
     */
    User selectByUserId(String userId);
}
