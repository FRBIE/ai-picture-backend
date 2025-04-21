package com.xrp.aipicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xrp.aipicturebackend.model.dto.space.SpaceAddRequest;

import com.xrp.aipicturebackend.model.dto.space.SpaceQueryRequest;
import com.xrp.aipicturebackend.model.entity.Space;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xrp.aipicturebackend.model.entity.User;
import com.xrp.aipicturebackend.model.vo.SpaceVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author x
* @description 针对表【space(空间)】的数据库操作Service
* @createDate 2025-04-21 14:53:55
*/
public interface SpaceService extends IService<Space> {

    void validSpace(Space space, boolean add);

    void fillSpaceBySpaceLevel(Space space);

    long addSpace(SpaceAddRequest spaceAddRequest, User loginUser);
    /**
     * 获取空间包装类（单条）
     */
    SpaceVO getSpaceVO(Space space, HttpServletRequest request);

    /**
     * 获取空间包装类（分页）
     */
    Page<SpaceVO> getSpaceVOPage(Page<Space> spacePage, HttpServletRequest request);

    /**
     * 获取查询对象
     */
    QueryWrapper<Space> getQueryWrapper(SpaceQueryRequest spaceQueryRequest);
}
