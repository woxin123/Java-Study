package com.example.controller;

import com.example.action.SaveProductAction;
import com.example.form.ProductForm;
import com.example.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.FloatBuffer;

@WebServlet(name = "ControllerServlet", urlPatterns = {"/product_input", "/product_save"})
public class ControllerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process (HttpServletRequest request, HttpServletResponse response) {
        String uri = request.getRequestURI();  // 返回取出后host(域名或者ip)部分的路径
        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex + 1);
        // 处理action
        if (action.equals("product_input")) {
            // 什么也不做
        } else if (action.equals("product_save")) {
            // 创建表单
            ProductForm productForm = new ProductForm();

            productForm.setName(request.getParameter("name"));
            productForm.setDescription(request.getParameter("description"));
            productForm.setPrice(request.getParameter("price"));

            // create model
            Product product = new Product();
            product.setName(productForm.getName());
            product.setDescription(productForm.getDescription());
            try {
                product.setPrice(Float.parseFloat(productForm.getPrice()));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            //  处理活动的方法
            SaveProductAction saveProductAction = new SaveProductAction();
            saveProductAction.save(product);
            request.setAttribute("product", product);
            // froward to a view

        }
        String dispatchUrl = null;
        if (action.equals("product_input")) {
            dispatchUrl = "/jsp/ProductForm.jsp";
        } else if (action.equals("product_save")) {
            dispatchUrl = "/jsp/ProductDetails.jsp";
        }
        if (dispatchUrl != null) {
            RequestDispatcher rd =
                    request.getRequestDispatcher(dispatchUrl);
            try {
                rd.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
