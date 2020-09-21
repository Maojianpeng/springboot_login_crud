package com.mingbyte.controller;

import com.mingbyte.pojo.dto.PageUserDto;
import com.mingbyte.pojo.dto.UserAddDto;
import com.mingbyte.pojo.dto.UserUpdateDto;
import com.mingbyte.pojo.vo.ResponseVo;
import com.mingbyte.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author M
 * @since 2020/9/16 17:26
 */
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired private UserService userService;

  /**
   * 查询用户
   *
   * @param id
   * @return
   */
  @GetMapping("/finduser")
  public ResponseVo FindUser(@RequestParam Long id) {
    return this.userService.userInfo(id);
  }

    /**
     * 查询所有用户
     * @return
     */
  @GetMapping("/alluser")
  public ResponseVo AllUser(){
      return this.userService.allUser();
  }

  /**
   * 新增用户
   * @param userAddDto
   * @return
   */
  @PutMapping("/adduser")
  public ResponseVo AddUser(@RequestBody @Valid UserAddDto userAddDto) {
    return this.userService.addUser(userAddDto);
  }

  /**
   * 分页查询
   * @param pageIndex
   * @param pageSize
   * @param pageUserDto
   * @return
   */
  @PostMapping("/page")
  public ResponseVo pageUser(
      @RequestParam int pageIndex,
      @RequestParam int pageSize,
      @RequestBody PageUserDto pageUserDto) {
    return this.userService.pageUser(pageIndex, pageSize, pageUserDto);
  }

  /**
   * 修改信息
   * @param id
   * @param userUpdateDto
   * @return
   */
  @GetMapping("/update")
  public ResponseVo updateUser(@RequestParam long id,@RequestBody UserUpdateDto userUpdateDto){
    return this.userService.updateUser(id, userUpdateDto);
  }

  @GetMapping("/delete")
  public ResponseVo deleteUser(@RequestParam long id){
    return this.userService.deleteUser(id);
  }

    /**
     * 判断这条数据存不存在
     * 存在 修改某些属性
     * 1把属性全部更新
     *
     * 查出数据 修改所有数据
     * 2修改部分字段 其余字段为空
     *
     *
     */

}
