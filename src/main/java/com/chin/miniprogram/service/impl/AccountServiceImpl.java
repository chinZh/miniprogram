package com.chin.miniprogram.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chin.miniprogram.entity.Account;
import com.chin.miniprogram.mapper.AccountMapper;
import com.chin.miniprogram.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.dc.pr.PRError;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chinZh
 * @since 2020-05-30
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account getAccount(String username,String  password) {
        QueryWrapper<Account> queryWrapper = new QueryWrapper();
        Map<String,Object> map = new HashMap<>(16);

        map.put("username",username);
        map.put("password",password);
        queryWrapper.allEq(map);
        Account account = accountMapper.selectOne(queryWrapper);
        return account;
    }
}
