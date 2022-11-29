package com.example.mybatispuls;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.mybatispuls.mapper.UserMapper;
import com.example.mybatispuls.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: fzykd
 * Date: 2022-11-29
 * Time: 19:25
 */

@SpringBootTest
public class MyBatisPlusWrapperTest {


    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1(){
        //SELECT id,name,age,email FROM t_user WHERE
        // (name LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
        //查询用户信息包含a 年龄在20到30之间 邮箱信息不为null的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","a")
                .between("age",20,30)
                .isNotNull("email");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test2() {
        //组装排序条件
        //查询用户信息 按照年龄的降序排序 年龄相同 按照id升序排序
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age")
                .orderByAsc("id");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test3(){
        //删除邮箱地址为null的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int ret = userMapper.delete(queryWrapper);
        System.out.println(ret);
    }

    @Test
    public void test4(){
        //条件构造器来修改
        //将（年龄大于20并且用户名中包含有a）或邮箱为null的用户信息修改
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //UPDATE t_user SET name=?, email=? WHERE
        // (age > ? AND name LIKE ? OR email IS NULL)
        queryWrapper.gt("age",20)
                .like("name","a")
                .or()
                .isNull("email");
        User user = new User();
        user.setName("小明");
        user.setEmail("shang@163.com");
        int ret = userMapper.update(user,queryWrapper);
        System.out.println(ret);
    }

    @Test
    public void test5(){
        //将（年龄大于20并且用户名中包含有a）或邮箱为null的用户信息修改
        //实现：将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
        //这两个条件优先级发生了变化
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //UPDATE t_user SET name=?, email=? WHERE
        //(name LIKE ? AND (age > ? OR email IS NULL))
        queryWrapper.like("name","a")
                //lambda中的条件优先执行
                .and(i->i.gt("age",20).or().isNull("email"));
        User user = new User();
        user.setName("小红");
        user.setEmail("shang@163.com");
        int ret = userMapper.update(user,queryWrapper);
        System.out.println(ret);
    }


    @Test
    public void test6(){
        //查询之后 输入指定的字段 select的组装
        //查询用户的名字 年龄 邮箱
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name","age","email");
        List<Map<String,Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void test7(){
        //子查询
        //查询id小于定于100的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("id","select id from t_user where id <= 100");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test8(){
        //将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.like("name","a")
                .and(i-> i.gt("age",20).or().isNull("email"));
        userUpdateWrapper.set("name","小黑").set("email","shang@163.com");
        int ret = userMapper.update(null,userUpdateWrapper);
        System.out.println(ret);
    }

    @Test
    public void test9(){
        //实际的业务场景
        String username = "";
        Integer ageBegin = 20;
        Integer ageEnd = 30;

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(username)){
            //isNotBlank 判断某个字符串不为空字符串 不为null 不为空白字符串
            queryWrapper.like("name",username);
        }
        if (ageBegin != null){
            queryWrapper.ge("age",ageBegin); //大于等于

        }
        if (ageEnd != null){
            queryWrapper.le("age",ageEnd); //小于等于
        }

        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }


    @Test
    public void test10(){
        String username = "";
        Integer ageBegin = 20;
        Integer ageEnd = 30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(username),"name",username)
                .ge(ageBegin != null,"age",ageBegin)
                .le(ageEnd != null,"age",ageEnd);
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }


    @Test
    public void test11(){
        String username = "";
        Integer ageBegin = 20;
        Integer ageEnd = 30;
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(username),User::getName,username)
                .ge(ageBegin != null,User::getAge,ageBegin)
                .le(ageEnd != null,User::getAge,ageEnd);
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test12(){
        //将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.like("name","a")
                .and(i-> i.gt("age",20).or().isNull("email"));
        userUpdateWrapper.set("name","小黑").set("email","shang@163.com");
        int ret = userMapper.update(null,userUpdateWrapper);
        System.out.println(ret);
    }

}
