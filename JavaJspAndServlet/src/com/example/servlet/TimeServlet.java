package com.example.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


@WebServlet(loadOnStartup = 1)
public class TimeServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        Timer t = new Timer(1000000, new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println(new Date());
            }
        });
        t.start();
    }
}
