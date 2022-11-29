package com.example.mybatispuls;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatispuls.mapper.UserMapper;
import com.example.mybatispuls.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: fzykd
 * Date: 2022-11-29
 * Time: 21:29
 */

@SpringBootTest
public class MyBatisPlusPluginsTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testPage(){
        Page<User> page = new Page<>(1,3);
        userMapper.selectPage(page,null);
        System.out.println(page);
    }

}
