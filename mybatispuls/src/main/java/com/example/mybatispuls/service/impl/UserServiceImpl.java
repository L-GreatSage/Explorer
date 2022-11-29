package com.example.mybatispuls.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatispuls.mapper.UserMapper;
import com.example.mybatispuls.pojo.User;
import com.example.mybatispuls.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: fzykd
 * Date: 2022-11-29
 * Time: 15:35
 */
@Service
//UserService创建完之后 要与自己相对应的实现类 实现类一般都在impl这个包
    //不仅要是实现UserService这个接口 还要继承mybatis-plus提供的实现类ServiceImpl<当前操作map的类型,实体类的类型>
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
