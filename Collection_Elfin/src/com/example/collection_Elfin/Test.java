package com.example.collection_Elfin;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Test", urlPatterns = "/Test")
public class Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<Title>欢迎</Title>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<p>Hello World<p>");
        pw.println("<p>Hello World</p>");
        pw.println("</body>");
        pw.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
