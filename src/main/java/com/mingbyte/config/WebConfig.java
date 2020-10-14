package com.mingbyte.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author M
 * @since 2020/9/1 15:35
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

//    @Autowired
//    private JwtFilter jwtFilter;
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        //静态资源释放
//        registry.addResourceHandler("/**")
//            .addResourceLocations("classpath:/static/**");
//        super.addResourceHandlers(registry);
//    }
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry){
//        registry.addViewController("/").setViewName("index");
//        registry.addViewController("/index.html").setViewName("index");
//    }
//
//
//    /**
//     * 注册拦截器
//     * @param registry
//     */
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//
//        registry.addInterceptor(jwtFilter)  //注册改拦截器
//            .addPathPatterns("/**")     //表示拦截所有的请求，
//            .excludePathPatterns("/login/**","/index","/login.html","/show.html","/static/**","/templates/**");  //排除 login 拦截
//    }
}
