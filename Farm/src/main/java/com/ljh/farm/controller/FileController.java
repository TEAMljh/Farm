package com.ljh.farm.controller;

import com.ljh.farm.entity.ImgSuffix;
import com.ljh.farm.service.ImgSuffixService;
import com.ljh.farm.util.LayUIResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Description
 * @Author ljh
 * @Date 2020/3/19 14:45
 */
@RestController
@RequestMapping("file")
public class FileController {

    @Autowired
    private ImgSuffixService imgSuffixService;

    Logger logger = LoggerFactory.getLogger(FileController.class);

    @PostMapping("fileUpload")
    public Object fileUpload(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        //判断文件是否为空
        if (file.isEmpty()) {
            return LayUIResult.error("文件为空");
        }
        //文件名
        String fileName = file.getOriginalFilename();
        String name = fileName.substring(0, fileName.lastIndexOf("."));
        logger.info("The name of the upload file: " + fileName);
        //后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("The suffix of the upload file: " + suffixName);
        //格式限制
        List<ImgSuffix> limit = imgSuffixService.list();
        //判断
        String limits = "";
        for (ImgSuffix po : limit) {
            limits += po.getSuffixName();
        }
        if (!limits.contains(suffixName)) {
            return LayUIResult.error("格式不正确");
        }
        try {
            //项目class目录绝对路径
            String path = ResourceUtils.getFile("classpath:").getParent().replace("target","/src/main/resources/static/assets");
//            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
            System.out.println(path);
            fileName = UUID.randomUUID() + suffixName;
            String url = "/upload/" + fileName;
            //保存路径
            File upload = new File(path + url);
            if (!upload.getParentFile().exists()) {
                upload.getParentFile().mkdirs();
            }
            //数据库保存的url
            logger.info("Upload url: " + upload.getAbsolutePath());

            //保存文件
            file.transferTo(upload);
            //保存返回的数据
            Map<String, String> data = new HashMap<>();
            data.put("url", url);
            data.put("fileName", name);
            data.put("suffix", suffixName);
            return LayUIResult.ok("保存成功", data);
        } catch (IOException e) {
            e.printStackTrace();
            return LayUIResult.error("保存出错");
        }
    }
}
