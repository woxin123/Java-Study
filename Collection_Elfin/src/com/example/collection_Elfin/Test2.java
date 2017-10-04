package com.example.collection_Elfin;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

@WebServlet(name = "Test2", urlPatterns = "/Test2")
public class Test2 extends HttpServlet {

    private String driver;
    private String url;
    private String user;
    private String pass;

    public void initParam(String fileName)  {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(fileName));
            driver = props.getProperty("driver");
            url = props.getProperty("url");
            user = props.getProperty("user");
            pass = props.getProperty("pass");
        } catch (FileNotFoundException fnfe) {
            System.out.println("找不到数据库驱动配置文件");
            fnfe.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("加载数据库驱动配置文件出错");
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/data;charset=UTF-8");
        // 加载数据库驱动配置
        initParam("E:\\project\\CollectionElfin\\mysql.ini");
        // 启动数据库
        try {
            System.out.println(driver);
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("找不到数据库驱动");
            e.printStackTrace();
        }
        BufferedReader in = new BufferedReader(req.getReader());
        PrintWriter out = resp.getWriter();
        String account = in.readLine();
        String password = in.readLine();
//        StringBuilder json = null;
//        while ((line = in.readLine()) != null) {
//            json.append(line);
//        }
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.fromObject(json);
//        String account = (String) jsonObject.get("account");
//        String password = (String) jsonObject.get("password");

        try (
                Connection conn = DriverManager.getConnection(url, user, pass);
                Statement stmt = conn.createStatement()
                ) {
            ResultSet resultSet = stmt.executeQuery("select account, password from test " +
                    "where account = '" + account + "' and password = '" + password + "';");
            if (resultSet.next()) {
                out.println("登陆成功");
                out.flush();
            } else {
                out.println("登陆失败");
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
