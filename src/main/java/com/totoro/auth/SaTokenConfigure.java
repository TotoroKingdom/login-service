package com.totoro.auth;

import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description TODO
 * @Author totoro
 * @Date 2022-07-09 22:25
 */
@Slf4j
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {

        // 注册拦截器
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            log.info("注册 Sa-Token 的路由拦截器");
            List<String> urls = new ArrayList<>();
            urls.add("/favicon.ico");
            urls.add("/**/doc.*");//swagger
            urls.add("/**/swagger-ui.*");//swagger
            urls.add("/**/swagger-resources");//swagger
            urls.add("/**/webjars/**");//swagger
            urls.add("/**/v3/api-docs/**");//swagger
            urls.add("/register/**");
            urls.add("/login");
            registry.addInterceptor(new SaRouteInterceptor())
                    .addPathPatterns("/**")
                    .excludePathPatterns(urls);
        }
}
