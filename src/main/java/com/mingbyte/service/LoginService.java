package com.mingbyte.service;

import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mingbyte.dao.AdminDao;
import com.mingbyte.enums.DeleteStatus;
import com.mingbyte.pojo.dto.LoginDto;
import com.mingbyte.pojo.dto.RegisterDto;
import com.mingbyte.pojo.po.Admin;
import com.mingbyte.pojo.vo.LoginVo;
import com.mingbyte.pojo.vo.RegisterVo;
import com.mingbyte.pojo.vo.ResponseVo;
import com.mingbyte.utils.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author M
 * @since 2020/9/15 14:03
 */
@Slf4j
@Service
public class LoginService {

  /** jwt 对称加密签名sign */
  @Value("${jwt.sign}")
  private String jwtSign;

  @Autowired private AdminDao adminDao;

  /**
   * 普通用户登录
   *
   * @return 登录信息
   */
  public ResponseVo adminLogin(LoginDto loginDto) {
    // 根据手机号密码查询用户
    Admin admin =
        this.adminDao.selectOne(
            new QueryWrapper<Admin>()
                .eq("tel", loginDto.getTel())
                .eq("password", DigestUtil.md5Hex(loginDto.getPassword())));
    ResponseVo<LoginVo> responseVo = new ResponseVo<>();
    if (admin == null) {
      log.error("手机号[{}]或密码[{}]错误！", loginDto.getTel(), loginDto.getPassword());
      responseVo.setCode(1);
      responseVo.setMessage("手机号或密码错误！");
      return responseVo;
    }
    if (admin.getIsDelete() == DeleteStatus.DELETE) {
      log.error("用户[{}]已禁用!", admin.getId());
      responseVo.setCode(2);
      responseVo.setMessage("账号已注销！");
      return responseVo;
    }


    responseVo.setCode(0);
    responseVo.setMessage("登录成功!!!!!!");
    responseVo.setBody(getLoginVo(admin, loginDto.getTel()));
    return responseVo;
  }


  /**
   * @param admin 当前登录用户信息
   * @param tel 手机号
   * @return LoginVo
   */
  private LoginVo getLoginVo(Admin admin, String tel) {
    // 封装登录成功后要返回的数据
    LoginVo loginVo = getLoginVo(admin);
    log.info("手机号[{}]登录成功!", tel);
    return loginVo;
  }

  /**
   * 获取登录返回信息
   *
   * @param admin 登录用户基本信息
   * @return LoginVo
   */
  private LoginVo getLoginVo(Admin admin) {

    // 组装要加密到 token 中的参数
    Map<String, Object> jwtArgs = new HashMap<>();
    jwtArgs.put("id", String.valueOf(admin.getId()));

    // 生成 token
    String token = JWTUtil.INSTANCE.generate(jwtArgs, this.jwtSign);

    // 设置返回参数
    LoginVo loginVo = new LoginVo();
    loginVo.setTel(admin.getTel());
    loginVo.setToken(token);
    loginVo.setId(admin.getId());
    loginVo.setAdmin_name(admin.getAdminName());
    return loginVo;
  }

  /**
   * 用户注册
   */
  public ResponseVo adminRegister(RegisterDto registerDto){

    String tel = registerDto.getTel();

    ResponseVo<RegisterVo> responseVo = new ResponseVo<>();

    Admin admin = this.adminDao.selectOne(new QueryWrapper<Admin>().eq("tel",tel));
    if (admin != null){
      log.error("手机号[{}]已经注册！", tel);
      responseVo.setCode(3);
      responseVo.setMessage("手机号已注册！");
      return responseVo;
    }
    Admin addAdmin = new Admin();
    addAdmin.setAdminName(registerDto.getAdminName());
    addAdmin.setTel(tel);
    addAdmin.setPassword(DigestUtil.md5Hex(registerDto.getPassword()));
    addAdmin.setIsDelete(DeleteStatus.NORMAL);
    this.adminDao.insert(addAdmin);

    log.info("手机号[{}]注册成功",tel);
    responseVo.setCode(4);
    responseVo.setMessage("注册成功");
    return responseVo;
  }
}
