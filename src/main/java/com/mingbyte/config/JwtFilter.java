package com.mingbyte.config;

import com.mingbyte.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author M
 * @since 2020/9/15 9:36
 */
@Configuration
public class JwtFilter extends HandlerInterceptorAdapter {

  /** jwt 对称加密签名sign */
  @Value("${jwt.sign}")
  private String jwtSign;

  @Override
  public boolean preHandle(
      HttpServletRequest request, HttpServletResponse response, Object handler) {
    // 允许跨域
    response.setHeader("Access-Control-Allow-Origin", "*");
    // 允许自定义请求头token(允许head跨域)
    response.setHeader(
        "Access-Control-Allow-Headers",
        "token, Accept, Origin, X-Requested-With, Content-Type, Last-Modified");
    // 避免预请求干扰
    if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
      return true;
    }
    String token = request.getHeader("Authorization");
    JWTUtil.JWT jwt = JWTUtil.INSTANCE.check(token, jwtSign);
//    System.out.println(token);
//    System.out.println(jwt.getStatus());
    if (jwt.getStatus() == 0) {
      return true;
    } else return false;
  }

  @Override
  public void postHandle(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      ModelAndView modelAndView)
      throws Exception {
    super.postHandle(request, response, handler, modelAndView);
  }

  @Override
  public void afterCompletion(
      HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
      throws Exception {
    super.afterCompletion(request, response, handler, ex);
  }
}
