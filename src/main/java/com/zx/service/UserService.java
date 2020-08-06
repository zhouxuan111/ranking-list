package com.zx.service;

import com.zx.model.User;

/**
 * @author zhouxuan
 * @date 2020/8/6 9:49
 */
public interface UserService {

    void add(User user);

    void delete(User user);

    void update(User user);

}
