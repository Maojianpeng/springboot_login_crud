package com.mingbyte.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author M
 * @since 2020/9/1 15:35
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Autowired
    private JwtFilter jwtFilter;

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////        registry.addResourceHandler("/**").addResourceLocations(
////            "classpath:/static/");
////        registry.addResourceHandler("swagger-ui.html").addResourceLocations(
////            "classpath:/META-INF/resources/");
////        registry.addResourceHandler("/webjars/**").addResourceLocations(
////            "classpath:/META-INF/resources/webjars/");
//        registry.addResourceHandler("/login").addResourceLocations(
//            "classpath:/templates/");
//        super.addResourceHandlers(registry);
//    }


    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(jwtFilter)  //注册改拦截器
            .addPathPatterns("/**")     //表示拦截所有的请求，
            .excludePathPatterns("/login/**");  //排除 login 拦截
    }
}
