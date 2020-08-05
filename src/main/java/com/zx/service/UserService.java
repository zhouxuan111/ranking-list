package com.zx.service;

/**
 * @author zhouxuan
 * @date 2020/8/5 17:02
 */
public interface UserService {

    /**
     * 新增
     * @param userId
     * @param score
     * @return
     */
    boolean zAddScore(String userId, double score);

    /**
     * 删除
     * @param userId
     * @return
     */
    void zRemove(String userId);

    /**
     * 更新
     * @param userId
     * @param delta
     * @return
     */
    boolean zUpdate(String userId, double delta);

}
