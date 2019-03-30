package top.mcwebsite.concurrency.example.threadlocal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mengchen
 * @time 19-3-30 下午11:36
 */
@RestController
@RequestMapping("/threadlocal")
public class ThreadLocalController {
    @RequestMapping("/test")
    public Long test() {
        return RequestHolder.getId();
    }
}
