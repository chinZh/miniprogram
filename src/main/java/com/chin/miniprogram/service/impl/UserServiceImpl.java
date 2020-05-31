package com.chin.miniprogram.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chin.miniprogram.entity.User;
import com.chin.miniprogram.mapper.UserMapper;
import com.chin.miniprogram.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chinZh
 * @since 2020-05-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> list(Integer pageNo, Integer pageSize) {
        Page<User> page = new Page<>(pageNo,pageSize);
        IPage<User> userIPage = userMapper.selectPage(page, null);
        return userIPage.getRecords();
    }

    @Override
    public User getById(Serializable id) {
        User user = userMapper.selectById(id);
        return user;
    }

    @Override
    public boolean save(User user) {
        if (userMapper.insert(user) > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateById(User user) {
        if (userMapper.updateById(user) > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeById(Serializable id) {
        if (userMapper.deleteById(id) > 0) {
            return true;
        } else {
            return false;
        }
    }
}
