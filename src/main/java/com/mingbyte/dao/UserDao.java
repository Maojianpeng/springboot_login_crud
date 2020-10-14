package com.mingbyte.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mingbyte.pojo.dto.PageUserDto;
import com.mingbyte.pojo.po.User;
import com.mingbyte.pojo.vo.UserVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author M
 * @since 2020/9/16 17:26
 */
@Repository
public interface UserDao extends BaseMapper<User> {

    UserVo findUserById(Long id);

    UserVo addUser(UserVo userVo);

//    UserVo updateUser(Long id);
//
//    UserVo deleteUser(Long id);

    List<UserVo> allUser();

    Page<UserVo> selectPageUser(Page<UserVo> page, @Param("dto") PageUserDto pageUserDto);
}
