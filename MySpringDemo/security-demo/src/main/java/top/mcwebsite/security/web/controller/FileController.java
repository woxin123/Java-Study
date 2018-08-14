package top.mcwebsite.security.web.controller;

import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.mcwebsite.security.dto.FileInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

/**
 * @author mengchen
 * @time 18-7-30 上午8:41
 */
@RestController
@RequestMapping("/file")
public class FileController {

    private String folder = "/home/mengchen/Study/JavaStudy/MySpringDemo/security-demo/src/main/java/top/mcwebsite/security/web/controller";

    @PostMapping
    public FileInfo upload(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());

        File localFile = new File(folder, System.currentTimeMillis() + ".txt");
        file.transferTo(localFile);

        return new FileInfo(localFile.getAbsolutePath());
    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
        try (InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
             OutputStream outputStream = response.getOutputStream()){
           response.setContentType("application/x-download");
           response.addHeader("Content-Disposition", "attachment;filename=test.txt");
            StreamUtils.copy(inputStream, outputStream);
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
