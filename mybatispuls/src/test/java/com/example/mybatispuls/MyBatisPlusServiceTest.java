package com.example.mybatispuls;

import com.example.mybatispuls.pojo.User;
import com.example.mybatispuls.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: fzykd
 * Date: 2022-11-29
 * Time: 16:01
 */

@SpringBootTest
public class MyBatisPlusServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetCount(){
        //查询总的记录数
        //SELECT COUNT( * ) FROM user
        long count = userService.count();
        System.out.println("总记录数:" + count);
    }

    @Transactional
    @Test
    public void testInsertMore(){
        List<User> list = new ArrayList<>();
        for (int i = 1; i <=10; i++) {
            User user = new User();
            user.setName("ybc"+i);
            user.setAge(20+i);
            list.add(user);
        }
        boolean b = userService.saveBatch(list);
        System.out.println(b);
    }


}
