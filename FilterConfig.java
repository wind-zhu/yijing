package com.huke.config;


import com.huke.common.filter.CorsFilter;
import com.huke.common.filter.VerifyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;

/**
 * @author zhu
 * date 2018/4/2
 */

public class FilterConfig extends WebMvcConfigurerAdapter{
    @Bean
    public FilterRegistrationBean filterCors() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        //注入过滤器
        registration.setFilter(corsFilter());
        //拦截规则
        registration.addUrlPatterns("/*");
        //过滤器名称
        registration.setName("corsFilter");
        //过滤器顺序
        registration.setOrder(Ordered.LOWEST_PRECEDENCE);
        return registration;
    };

    @Bean
    public Filter corsFilter() {
        return new CorsFilter ();
    };

    @Bean
    public FilterRegistrationBean filterVerifyReg(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        //注入过滤器
        registration.setFilter(verifyFilter ());
        //拦截规则
        registration.addUrlPatterns("/*");
        //过滤器名称
        registration.setName("signFilter");
        //过滤器顺序
        registration.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return registration;
    }

    @Bean
    public Filter verifyFilter() {
        return new VerifyFilter ();
    }
}
