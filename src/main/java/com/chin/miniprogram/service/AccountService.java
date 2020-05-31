package com.chin.miniprogram.service;

import com.chin.miniprogram.entity.Account;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chinZh
 * @since 2020-05-30
 */
public interface AccountService extends IService<Account> {
    public Account getAccount(String username, String password);
}
