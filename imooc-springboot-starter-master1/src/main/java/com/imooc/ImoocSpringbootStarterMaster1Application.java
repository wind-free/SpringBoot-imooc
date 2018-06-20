package com.imooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
//扫描 mybatis mapper 包路径
@MapperScan(basePackages = "com.imooc.mapper")
//扫描 所有需要的包, 包含一些自用的工具类包 所在的路径
@ComponentScan(basePackages= {"com.imooc", "org.n3r.idworker"})
public class ImoocSpringbootStarterMaster1Application {

	public static void main(String[] args) {
		SpringApplication.run(ImoocSpringbootStarterMaster1Application.class, args);
	}
}
