package top.mcwebsite.mybatis.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import top.mcwebsite.mybatis.web.model.SysDict;

import java.util.Date;

@Controller
public class IndexController {


    @GetMapping("/")
    public String index() {
        return "/dicts?offset=0&limit=3";
    }

    @RequestMapping("/index")
    public ModelAndView dicts() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("now", new Date());
        return mv;
    }
}
