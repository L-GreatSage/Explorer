package com.example.mybatispuls;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//扫描mapper接口所在的包
@MapperScan("com.example.mybatispuls.mapper")
public class MybatispulsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatispulsApplication.class, args);
	}

}
