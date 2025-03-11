package com.xrp.aipicturebackend.service;

import cn.hutool.http.server.HttpServerRequest;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xrp.aipicturebackend.model.dto.user.UserQueryRequest;
import com.xrp.aipicturebackend.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xrp.aipicturebackend.model.vo.LoginUserVO;
import com.xrp.aipicturebackend.model.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author x
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2025-03-11 10:16:36
*/
public interface UserService extends IService<User> {

    long userRegister(String userAccount, String userPassword, String checkPassword);
    LoginUserVO userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 获取脱敏后的已登录用户信息
     */
    LoginUserVO getLoginUserVO(User user);

    /**
     * 获取加密后的密码
     * @param userPassword
     * @return
     */
    String getEncryptPassword(String userPassword);

    /**
     * 获取当前登录用户(未脱敏)
     * @param request
     * @return
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 用户注销
     */
    boolean userLogout(HttpServletRequest request);

    UserVO getUserVO(User user);

    List<UserVO> getUserVOList(List<User> userList);

    QueryWrapper<User> getQueryWrapper(UserQueryRequest userQueryRequest);
}
