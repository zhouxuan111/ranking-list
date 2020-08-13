package com.zx.model;

import java.io.Serializable;

import lombok.Data;

/**
 * @author zhouxuan
 * @date 2020/8/6 9:55
 */
@Data
public class User implements Serializable {

    private String name;

    private String userId;

    private Integer score;
}
