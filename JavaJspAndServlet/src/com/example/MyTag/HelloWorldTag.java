package com.example.MyTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class HelloWorldTag extends SimpleTagSupport {
    // 重写doTag()方法，该方法为标签生成页面内容
    @Override
    public void doTag() throws JspException, IOException {
        // 获取页面输出流，并输出字符
        getJspContext().getOut().write("Hello World " + new java.util.Date());
    }
}
