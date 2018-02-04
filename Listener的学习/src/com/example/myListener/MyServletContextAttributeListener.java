package com.example.myListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * 用于检测ServletContext(application)范围内的变化
 */
@WebListener
public class MyServletContextAttributeListener implements ServletContextAttributeListener {
    // 当程序中application范围添加属性时触发该方法
    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        ServletContext application = servletContextAttributeEvent.getServletContext();
        // 添加获取的属性名和属性值
        String name = servletContextAttributeEvent.getName();
        Object value = servletContextAttributeEvent.getValue();
        System.out.println("application" + "范围内添加了名为" + name + ", 值为" + value + "的属性!");
    }
    // 当程序从application范围内删除属性时触发该方法
    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        ServletContext application = servletContextAttributeEvent.getServletContext();
        // 删除获取的属性名和属性值、
        String name = servletContextAttributeEvent.getName();
        Object value = servletContextAttributeEvent.getValue();
        System.out.println("application" + "范围名为" + name + ", 值为" + value + "的属性被删了!");
    }
    // 当application范围内的值被替换时
    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        ServletContext application = servletContextAttributeEvent.getServletContext();
        // 替换获取的属性名和属性值、
        String name = servletContextAttributeEvent.getName();
        Object value = servletContextAttributeEvent.getValue();
        System.out.println("application" + "范围名为" + name + ", 值为" + value + "的属性被替换了!");
    }
}
