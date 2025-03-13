package com.xrp.aipicturebackend.controller;

import com.qcloud.cos.model.COSObject;
import com.qcloud.cos.model.COSObjectInputStream;
import com.qcloud.cos.utils.IOUtils;
import com.xrp.aipicturebackend.annotation.AuthCheck;
import com.xrp.aipicturebackend.common.BaseResponse;
import com.xrp.aipicturebackend.common.ResultUtils;
import com.xrp.aipicturebackend.constant.UserConstant;
import com.xrp.aipicturebackend.exception.BusinessException;
import com.xrp.aipicturebackend.exception.ErrorCode;
import com.xrp.aipicturebackend.manager.CosManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {

    @Resource
    private CosManager cosManager;

    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    @PostMapping("/test/upload")
    public BaseResponse<String> testUploadFile(@RequestPart("file") MultipartFile mutipartFile) {
        String filename = mutipartFile.getOriginalFilename();
        String filePath = String.format("/test/%s",filename);
        File file = null;
        try {
            file = File.createTempFile(filePath, null);
            //将内存中的临时文件持久化
            mutipartFile.transferTo(file);
            cosManager.putObject(filePath,file);
            //返回可访问地址
            return ResultUtils.success(filePath);
        }catch (Exception e) {
            log.error("file upload error,filepath = {}", filePath, e);
            throw new BusinessException(ErrorCode.SYSTEM_ERROR,"上传失败");
        }finally {
            if(file!=null){
                boolean delete = file.delete();
                if(!delete){
                    log.error("file delete error,filepath = {}", filePath);
                }
            }

        }
    }

    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    @GetMapping("/test/download")
    public void testDownloadFile(String filePath, HttpServletResponse response) throws IOException {
        COSObjectInputStream cosObjectInputStream = null;
        try {
            //
            COSObject cosObject = cosManager.getObject(filePath);
            cosObjectInputStream = cosObject.getObjectContent();
            // 处理下载到的流
            byte[] bytes = IOUtils.toByteArray(cosObjectInputStream);
            //设置响应头
            response.setContentType("application/octet-stream;charset=utf-8");
            response.setHeader("Content-Disposition","attachment; filename=" + filePath);
            //写入响应
            response.getOutputStream().write(bytes);
            response.getOutputStream().flush();
        }catch (Exception e) {
            log.error("file download error,filepath = {}", filePath, e);
            throw new BusinessException(ErrorCode.SYSTEM_ERROR,"下载失败");
        }finally {
            if(cosObjectInputStream!=null){
                cosObjectInputStream.close();
            }
        }
    }


}
