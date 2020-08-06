package com.zx.dao;

import com.zx.model.User;
import org.springframework.stereotype.Repository;

/**
 * @author zhouxuan
 * @date 2020/8/6 9:51
 */
@Repository
public interface UserDao {

    void add(User user);

    void delete(User user);

    void update(User user);
}
