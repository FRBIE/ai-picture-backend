package com.xrp.aipicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xrp.aipicturebackend.model.dto.picture.PictureQueryRequest;
import com.xrp.aipicturebackend.model.dto.picture.PictureReviewRequest;
import com.xrp.aipicturebackend.model.dto.picture.PictureUploadRequest;
import com.xrp.aipicturebackend.model.entity.Picture;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xrp.aipicturebackend.model.entity.User;
import com.xrp.aipicturebackend.model.vo.PictureVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
* @author x
* @description 针对表【picture(图片)】的数据库操作Service
* @createDate 2025-03-12 14:56:47
*/
public interface PictureService extends IService<Picture> {

    PictureVO uploadPicture(MultipartFile multipartFile,
                            PictureUploadRequest pictureUploadRequest,
                            User loginUser);

    QueryWrapper<Picture> getQueryWrapper(PictureQueryRequest pictureQueryRequest);

    PictureVO getPictureVO(Picture picture, HttpServletRequest request);

    Page<PictureVO> getPictureVOPage(Page<Picture> picturePage, HttpServletRequest request);

    void validPicture(Picture picture);

    /**
     * 图片审核
     * @param pictureReviewRequest
     * @param loginUser
     */
    void doPictureReview(PictureReviewRequest pictureReviewRequest,User loginUser);

    void fillReviewParams(Picture picture, User loginUser);
}
