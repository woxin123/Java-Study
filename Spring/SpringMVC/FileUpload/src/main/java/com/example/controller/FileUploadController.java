package com.example.controller;


import com.example.domain.User;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class FileUploadController {
    private static final Logger logger = Logger.getLogger(FileUploadController.class);

    @RequestMapping(value = "/{formName}")
    public String loginForm(@PathVariable String formName) {
        // 动态跳转页面
        return formName;
    }

    @RequestMapping(value = "/upload", method = POST)
    public String upload(@RequestParam("description") String description,
                         @RequestParam("file") MultipartFile file,
                         HttpServletRequest request) throws IOException {
        System.out.println(description);
        // 如果文件不为空，写入上传路径
        if (!file.isEmpty()) {
            // 上传路径
            String path = request.getServletContext().getRealPath("/images/");
            // 上传的文件名
            String fileName = file.getOriginalFilename();
            File filepath = new File(path, fileName);
            // 判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdir();
            }
            file.transferTo(new File(path + File.separator + fileName));
            System.out.println(path + File.separator + fileName);
            return "success";
        } else {
            return "error";
        }
    }

    @RequestMapping("/register")
    public String register(@ModelAttribute User user, Model model,
                           HttpServletRequest request) throws IOException {
        System.out.println(user.getUsername());
        // 如果文件名不为空，写入上传路径
        if (!user.getImage().isEmpty()) {
            // 写入上传路径
            String path = request.getServletContext().getRealPath("/images/");
            // 上传的文件名
            String fileName = user.getImage().getOriginalFilename();
            File filepath = new File(path, fileName);
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdir();
            }
            // 上传文件
            user.getImage().transferTo(filepath);
            model.addAttribute("user", user);
            return "userInfo";
        } else {
            return "error";
        }
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,
                                           @RequestParam("fileName") String fileName,
                                           Model model) throws IOException {
        // 下载路径
        String path = request.getServletContext().getRealPath("/images/");
        File file = new File(path + fileName);
        HttpHeaders headers = new HttpHeaders();
        // 下载显示文件名，解决中文名称乱码问题
        String downloadFileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
        // 通知浏览器以attachment（下载方式）打开图片
        headers.setContentDispositionFormData("attachment", downloadFileName);
        // application/octet-stream ： 二进制流数据（最常见的文件下载）。
        headers.setContentType(APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }
}
