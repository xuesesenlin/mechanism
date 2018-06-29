package org.ld.mechanism;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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

    //跨域
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:9000");
            }
        };
    }

}
