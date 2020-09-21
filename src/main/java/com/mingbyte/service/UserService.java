package com.mingbyte.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mingbyte.dao.UserDao;
import com.mingbyte.enums.DeleteStatus;
import com.mingbyte.pojo.dto.PageUserDto;
import com.mingbyte.pojo.dto.UserAddDto;
import com.mingbyte.pojo.dto.UserUpdateDto;
import com.mingbyte.pojo.po.User;
import com.mingbyte.pojo.vo.ResponseVo;
import com.mingbyte.pojo.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author M
 * @since 2020/9/16 17:27
 */
@Service
@Slf4j
public class UserService {


    @Autowired
    private UserDao userDao;

    /**
     * 查询所有用户
     * @return
     */
    public ResponseVo allUser(){

        ResponseVo responseVo = new ResponseVo();
        List<UserVo> list = this.userDao.allUser();

        log.info("全部用户查询成功");
        responseVo.setCode(6);
        responseVo.setMessage("全部用户查询成功");
        responseVo.setBody(list);
        return responseVo;
    }

    /**
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    public ResponseVo userInfo(Long id){

        ResponseVo responseVo = new ResponseVo();
        UserVo userVo=this.userDao.findUserById(id);

//        if ( != 1){
//            log.info("[{}]该用户已被删除",id);
//            responseVo.setCode(11);
//            responseVo.setMessage("该用户已被删除");
//            return null;
//        }else {
            log.info("已查询[{}]的用户信息",id);
            responseVo.setCode(7);
            responseVo.setMessage("已查询该用户信息");
            responseVo.setBody(userVo);
            return responseVo;
//        }
    }

    /**
     * 新增用户
     * @param userAddDto
     * @return
     */
    public ResponseVo addUser(UserAddDto userAddDto){

        String username = userAddDto.getUserName();

        ResponseVo responseVo = new ResponseVo();

        User addUser = new User();
        addUser.setUserName(userAddDto.getUserName());
        addUser.setAge(userAddDto.getAge());
        addUser.setIsDelete(DeleteStatus.NORMAL);
        this.userDao.insert(addUser);

        log.info("用户[{}]添加成功",username);
        responseVo.setCode(5);
        responseVo.setMessage("用户添加成功");
        responseVo.setBody(addUser);
        return responseVo;
    }

    /**
     * 分页查询
     * @param pageIndex
     * @param pageSize
     * @param pageUserDto
     * @return
     */
    public ResponseVo pageUser(int pageIndex, int pageSize, PageUserDto pageUserDto){

        ResponseVo responseVo = new ResponseVo();
        Page<UserVo> page = new Page<>(pageIndex,pageSize);

        this.userDao.selectPageUser(page,pageUserDto);

        log.info("查询成功");
        responseVo.setCode(8);
        responseVo.setMessage("查询成功");
        responseVo.setBody(page);

        return responseVo;
    }

    /**
     * 修改用户信息
     * @param userUpdateDto
     * @param id
     * @return
     */
    public ResponseVo updateUser(Long id,UserUpdateDto userUpdateDto){

        ResponseVo responseVo = new ResponseVo();

        User updateUser = new User();
        updateUser.setAge(userUpdateDto.getAge());
        updateUser.setUserName(userUpdateDto.getUserName());

        updateUser.setId(id);

        this.userDao.updateById(updateUser);

        log.info("修改成功");
        responseVo.setCode(9);
        responseVo.setMessage("修改成功");
        responseVo.setBody(updateUser);

        return responseVo;
    }

    /**
     * 逻辑删除，将需要删除用户的is_delete标识修改为0
     * @param id
     * @return
     */
    public ResponseVo deleteUser(Long id){

        ResponseVo responseVo = new ResponseVo();

        User deleteUser = new User();
        deleteUser.setId(id);
        deleteUser.setIsDelete(DeleteStatus.DELETE);

        this.userDao.updateById(deleteUser);

        log.info("删除成功");
        responseVo.setCode(10);
        responseVo.setMessage("删除成功");
        responseVo.setBody(deleteUser);

        return responseVo;
    }
}
