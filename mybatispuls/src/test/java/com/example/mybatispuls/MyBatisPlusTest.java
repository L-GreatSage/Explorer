package com.example.mybatispuls;

import com.example.mybatispuls.mapper.UserMapper;
import com.example.mybatispuls.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    @Test
    //新增方法
    public void testInsert(){
        //新增用户信息
        User user = new User();
        //user.setId(100L);
        user.setName("张三");
        user.setAge(23);
        user.setEmail("zhangsan@atugi.com");
        int ret = userMapper.insert(user);
        System.out.println(ret);
        System.out.println("id: " + user.getId());
    }

    //删除方法
    @Test
    public void testDelete(){
        //DELETE FROM user WHERE id=?
        //通过id来删除 id超过了int类型的大小 后面加一个L 表示long类型的数据
        int ret = userMapper.deleteById(1597479168112508930L);
        System.out.println(ret);
    }

    @Test
    public void testDelete1(){
        //DELETE FROM user WHERE name = ? AND age = ?
        //首先 创建一个Map集合
        Map<String,Object> map = new HashMap<>();
        //添加一些删除的条件 name=张三的删除
        map.put("name","张三");
        map.put("age","23");
        //通过一个map集合来删除 map集合放的是当前要删除的条件
        int ret = userMapper.deleteByMap(map);
    }

    @Transactional
    @Test
    public void testDelete2(){
        //DELETE FROM user WHERE id IN ( ? , ? , ? )
        List<Long> list = Arrays.asList(1L,2L,3L);
        //通过多个id实现 批量删除的操作
        int ret = userMapper.deleteBatchIds(list);
        System.out.println(ret);
    }


    @Test
    public void testUpdate(){
        //更具id来进行修改
        //UPDATE user SET name=?, email=? WHERE id=?
        User user = new User();
        user.setId(4L);
        user.setName("李四");
        user.setEmail("list@163.com");
        int ret = userMapper.updateById(user);
        System.out.println(ret);
    }

    @Test
    public void testSelect(){
        //SELECT id,name,age,email FROM user WHERE id=?
        //根据id查询用户信息
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    @Test
    public void testSelect1(){
        //SELECT id,name,age,email FROM user WHERE id IN ( ? , ? , ? )
        //根据多个id查询多个用户信息
        List<Long> list = Arrays.asList(1L,2L,3L);
        List<User> users = userMapper.selectBatchIds(list);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelect2(){
        //SELECT id,name,age,email FROM user WHERE name = ?
        Map<String,Object> map = new HashMap<>();
        map.put("name","李四");
        //通过map集合来进行条件查询
        List<User> user = userMapper.selectByMap(map);
        user.forEach(System.out::println);
    }

    @Test
    public void testSelect3(){
        //SELECT id,name,age,email FROM user
        //传入的参数是一个条件构造器 没有条件可以写null
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelect4(){
        //select id,name,age,email from user where id = ?
        Map<String,Object> map = userMapper.selectMapById(1L);
        System.out.println(map);
    }

}
