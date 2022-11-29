package com.example.mybatispuls.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatispuls.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: fzykd
 * Date: 2022-11-23
 * Time: 20:26
 */

@Repository
public interface UserMapper extends BaseMapper<User> {

    //根据id查询用户信息为map集合
    Map<String,Object> selectMapById(Long id);
}
