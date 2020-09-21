package com.mingbyte;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author M
 * @since 2020/9/15 11:15
 */
@SpringBootApplication(scanBasePackages = "com.mingbyte")
@MapperScan("com.mingbyte.dao")
public class Application {
  public static void main(String[] args) {
    //
      SpringApplication.run(Application.class,args);
    System.out.println("Application Start!");
  }
}
