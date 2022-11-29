package com.example.mybatispuls.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: fzykd
 * Date: 2022-11-23
 * Time: 20:23
 */

@Data
//设置实体类所对应的表明 和数据库中的表明一致
@TableName("t_user")
public class User {


    //当表的主键不是id 但是Mybatis又是根据id来比对的
    //使用@TableId 将这属性对应的字段 指定为主键
    //@TableId(value = "uid",type = IdType.AUTO)

    private Long id;

    private String name;

    private Integer age;

    private String email;

}
