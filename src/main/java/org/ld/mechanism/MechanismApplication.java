package org.ld.mechanism;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//oauthor2 授权服务器
//@EnableAuthorizationServer
//oauthor2 资源服务器
//@EnableResourceServer
//开启声明式缓存
@EnableCaching
public class MechanismApplication {

    public static void main(String[] args) {
        SpringApplication.run(MechanismApplication.class, args);
    }

}
