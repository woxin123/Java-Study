package top.mcwebsite.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author mengchen
 * @time 19-2-18 下午4:15
 */
public interface FileService {
    String upload(MultipartFile file, String path);
}
