package com.itheima.mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.query.UserQuery;
import com.itheima.mp.domain.vo.UserVO;

import java.util.List;

/**
 * IUserService 用户Service接口
 *
 * @author hhuzzz
 * @version 2024/01/07 14:02
 */
public interface IUserService extends IService<User> {

    void deductBalance(Long id, Integer money);

    List<UserVO> queryUsers(UserQuery query);
}