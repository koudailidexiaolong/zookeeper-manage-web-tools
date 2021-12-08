package com.julong.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * zookeeper 客户端启动程序主类
 * @author julong
 * @date 2021年10月26日 下午4:02:03
 * @desc 
 */
@SpringBootApplication
@ComponentScan(basePackages="com.julong")
public class ZookeeperWebUIApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ZookeeperWebUIApplication.class, args);
	}

}
