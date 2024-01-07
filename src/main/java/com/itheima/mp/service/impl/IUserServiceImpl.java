package com.itheima.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.mapper.UserMapper;
import com.itheima.mp.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * IUserServiceImpl 用户Service实现
 *
 * @author hhuzzz
 * @version 2024/01/07 14:03
 */
@Service
public class IUserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public void deductBalance(Long id, Integer money) {
        User user = getById(id);
        if (user == null || user.getStatus() == 2) {
            throw new RuntimeException("账号不存在或账号异常");
        }
        if (user.getBalance() < money) {
            throw new RuntimeException("用户余额不足");
        }
        baseMapper.deductBalance(id, money);
    }
}