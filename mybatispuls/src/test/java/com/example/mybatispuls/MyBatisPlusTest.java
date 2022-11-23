package com.example.mybatispuls;

import com.example.mybatispuls.mapper.UserMapper;
import com.example.mybatispuls.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: fzykd
 * Date: 2022-11-23
 * Time: 20:30
 */

@SpringBootTest
public class MyBatisPlusTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void testSelectList(){
        //通过条件构造器来查询一个list集合 如果没有条件可以设置null为参数
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }

    @Transactional
    @Test
    public void testInsert(){
        //新增用户信息
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        user.setEmail("zhangsan@atugi.com");
        int ret = userMapper.insert(user);
        System.out.println(ret);
        System.out.println("id: " + user.getId());
    }
}
