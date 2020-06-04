package com.imooc.user;

import com.imooc.user.thrift.ThriftServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserThriftServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserThriftServiceApplication.class, args);
    }

    /**
     * 向Spring注册一个Bean对象
     * initMethod = "start"  表示会执行名为start的方法
     * start方法执行之后，就会阻塞接受客户端的请求
     *
     * @return
     */
    @Bean(initMethod = "start")
    public ThriftServer init() {
        return new ThriftServer();
    }
}
