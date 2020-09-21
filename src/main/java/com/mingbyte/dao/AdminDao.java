package com.mingbyte.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mingbyte.pojo.po.Admin;
import com.mingbyte.pojo.vo.AdminVo;
import com.mingbyte.pojo.vo.RegisterVo;
import org.springframework.stereotype.Repository;

/**
 * @author M
 * @since 2020/9/15 14:01
 */
@Repository
public interface AdminDao extends BaseMapper<Admin> {


    AdminVo loginAdminByTelAndPass(Admin admin);

    RegisterVo registerAdmin(RegisterVo registerVo);
}
