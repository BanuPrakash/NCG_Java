package com.adobe.prj.dao;

import com.adobe.prj.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoJdbcImpl implements ProductDao{
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private  static final String URL = "jdbc:mysql://localhost:3306/JAVA_SPRING";
    private static final String USERNAME ="root";
    private static final String PASSWORD = "Welcome123";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void addProduct(Product p) {
        String SQL = "insert into products (id, name, price) values (0, ?, ?)";
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        String SQL = "SELECT  id, name, price FROM products";
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()) {
                Product p = new Product(rs.getInt("id"),
                        rs.getString("name"), rs.getDouble("price"));
                products.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return products;
    }
}
