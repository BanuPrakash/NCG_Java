package com.adobe.prj.web;

import com.adobe.prj.dao.PersistenceException;
import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.dao.ProductDaoJdbcImpl;
import com.adobe.prj.entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    // GET http://localhost:8080/products
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("text/html"); // MIME
        PrintWriter out = resp.getWriter(); // opens character stream to client [BROWSER]
//        ServletOutputStream out = resp.getOutputStream(); // binary data
        out.println("<html><body>");
        out.println("<table>");
        out.println("<tr><th>ID</th><th>Name</th><th>Price</th></tr>");
        ProductDao productDao = new ProductDaoJdbcImpl();
        List<Product> products = productDao.getProducts();
        for(Product p: products) {
            out.println("<tr>");
            out.println("<td>" + p.getId() + " </td>");
            out.println("<td>" + p.getName() + " </td>");
            out.println("<td>" + p.getPrice() + " </td>");
            out.println("</tr>");
        }
        out.println("</table></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product p = new Product();
        p.setName(req.getParameter("name"));
        p.setPrice(Double.parseDouble(req.getParameter("price")));
        ProductDao productDao = new ProductDaoJdbcImpl();
        try {
            productDao.addProduct(p);
           // System.out.println("Product Added!!!");
            resp.sendRedirect("index.jsp?msg=Product Added!!!");
        } catch (PersistenceException e) {
//            System.out.println(e.getMessage());
            e.printStackTrace(); // development stage
            resp.sendRedirect("index.jsp?" + e.getMessage());
        }
    }
}
