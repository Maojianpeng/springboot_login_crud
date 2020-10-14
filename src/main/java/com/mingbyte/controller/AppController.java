package com.mingbyte.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author M
 * @since 2020/10/12 11:22
 */
@Controller
public class AppController {

  @RequestMapping("/index")
  public String index() {
    return "index";
  }

  @RequestMapping("/login")
  public String login() {
    return "login";
  }

  @RequestMapping("/register")
  public String register() {
    return "register";
  }

  @RequestMapping("/show")
  public String success() {
    return "show";
  }

  @RequestMapping("/add")
  public String add(){
    return "add";
  }
}
