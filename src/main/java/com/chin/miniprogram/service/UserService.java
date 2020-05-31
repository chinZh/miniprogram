package com.chin.miniprogram.service;

import com.chin.miniprogram.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chinZh
 * @since 2020-05-30
 */
public interface UserService extends IService<User> {
    public List<User> list(Integer pageNo, Integer pageSize);
}
