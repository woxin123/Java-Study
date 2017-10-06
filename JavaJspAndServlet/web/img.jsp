<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="java.awt.*" %>
<%@ page import="javax.imageio.ImageIO" %><%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/6
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="image/jpeg" language="java" %>
<html>
    <head>
        <title>图像</title>
    </head>
    <body>
        <%
            // 创建一个BufferedImage
            BufferedImage image = new BufferedImage(340, 160, BufferedImage.TYPE_INT_RGB);
            // 以Image对象获取Graphics对象
            Graphics g = image.getGraphics();
            // 使用Graphics画图，所画的图像将呈现在image上
            g.fillRect(0, 0, 400, 400);
            // 设置颜色：红
            g.setColor(new Color(255, 0, 0));
            g.fillArc(20, 20, 100, 100, 30, 120);
            // 设置颜色：绿
            g.setColor(new Color(0, 255, 0));
            // 画一段弧
            g.fillArc(20, 20, 100, 100, 150, 120);
            // 设置颜色：蓝
            g.setColor(new Color(0, 0, 255));
            // 画一段弧
            g.fillArc(20, 20, 100, 100, 270, 120);
            // 设置颜色：黑
            g.setColor(new Color(0, 0, 0));
            g.setFont(new Font("Arial Black", Font.PLAIN, 16));
            // 画出3个字符串
            g.drawString("red:climb", 200, 60);
            g.drawString("green:swim", 200, 100);
            g.drawString("blue:jump", 200, 140);
            g.dispose();
            // 将图像输出到页面响应
            ImageIO.write(image, "jpg", response.getOutputStream());
        %>
    </body>
</html>
