package com.mingbyte.controller;

import com.mingbyte.pojo.dto.LoginDto;
import com.mingbyte.pojo.dto.RegisterDto;
import com.mingbyte.pojo.vo.ResponseVo;
import com.mingbyte.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author M
 * @since 2020/9/15 16:12
 */
@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {
  @Autowired private LoginService loginService;

  /**
   * 管理员登录
   *
   * @param loginDto 登录参数
   * @return LoginVo
   */
  @ResponseBody
  @PostMapping("/gologin")
  public ResponseVo login(@Valid @RequestBody LoginDto loginDto) throws Exception {
    return this.loginService.adminLogin(loginDto);
  }

  /**
   * 管理员注册
   * @param registerDto
   * @return
   * @throws Exception
   */
  @ResponseBody
  @PutMapping("/register")
  public ResponseVo register(@Valid @RequestBody RegisterDto registerDto) throws Exception{
    return this.loginService.adminRegister(registerDto);
  }

}
