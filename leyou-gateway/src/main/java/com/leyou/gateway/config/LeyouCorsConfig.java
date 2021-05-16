package com.leyou.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author fenco
 * @date 2021/5/16 01:05
 */
@Configuration
public class LeyouCorsConfig  {
    @Bean
    public CorsFilter corsFilter() {
        //1.添加cors配置信息
        CorsConfiguration config = new CorsConfiguration();
        //1.1.允许的域，不要写*，否则cookie就无法使用了
        //【问题：将http写成类https搞了好久】
        config.addAllowedOrigin("http://manage.leyou.com");
        //1.2.是否发送cookie
        config.setAllowCredentials(true);
        //1.3.允许的请求方式
        config.addAllowedMethod("*");
        //1.4.允许的头信息
        config.addAllowedHeader("*");

        //2.添加映射，拦截一切请求
        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/**",config);

        //3.返回新的CorsFilter
        return new CorsFilter(configurationSource);
    }

/*    *//**
     * 用于设置跨域调用
     *//*
    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "http://manage.leyou.com");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept,X-API-UserId,X-API-Token");
        response.setHeader("Access-Control-Expose-Headers", "Location");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
    }*/
}
