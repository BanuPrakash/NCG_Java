package com.adobe.prj.orderapp.service;

import com.adobe.prj.orderapp.dao.CustomerDao;
import com.adobe.prj.orderapp.dao.OrderDao;
import com.adobe.prj.orderapp.dao.ProductDao;
import com.adobe.prj.orderapp.dto.ReportDTO;
import com.adobe.prj.orderapp.entity.Customer;
import com.adobe.prj.orderapp.entity.LineItem;
import com.adobe.prj.orderapp.entity.Order;
import com.adobe.prj.orderapp.entity.Product;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ProductDao productDao;
    private final CustomerDao customerDao; // generated implementation class by Spring Data Jpa is wired
    private final OrderDao orderDao;

    public List<Order> getByDate(String orderdate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return orderDao.getOrderForGivenDate(sdf.parse(orderdate));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return  null;
    }
    public List<ReportDTO> getReport(int id) {
        return orderDao.getReport(id);
    }
    /*
        order
        {
         "customer": {
                    "email": "rita@adobe.com"
            },
          "items" : [
                {"product": {"id": 3}, "qty" : 2},
                 {"product": {"id": 1}, "qty" : 1}
          ]
        }
     */

    @Transactional
    public String placeOrder(Order order) {
        double total = 0.0;
        List<LineItem> items = order.getItems();
        for(LineItem item: items) {
            Product p = productDao.findById(item.getProduct().getId()).get(); // id, name, price , qty
            if(p.getQuantity() < item.getQty()) {
                throw  new IllegalArgumentException("Product " + p.getName() + " not in stock!!!");
            }
            item.setAmount(item.getQty() * p.getPrice()); // + discount , TAX
            total += item.getAmount();

            p.setQuantity(p.getQuantity() - item.getQty());  // DIRTY CHECKING ORM feature
        }
        order.setTotal(total);
        orderDao.save(order); // cascade --> saves items also
        return "order placed!!!";
    }

    public List<Order> getOrders() {
        return orderDao.findAll();
    }
    public Order getOrderById(int id) {
        return orderDao.findById(id).get();
    }

    @Transactional
    public Product updateProduct(int id, double price) {
        Product p = productDao.findById(id).get(); // id, name, price , qty
        p.setPrice(price);
        return p;
    }

    public long getCustomerCount() {
        return customerDao.count();
    }

    public List<Product> getByRange(double low, double high) {
        return productDao.findByPriceBetween(low, high);
    }


    public List<Product> getProducts() {
        return productDao.findAll();
    }

    public Product addProduct(Product p) {
        return productDao.save(p);
    }

    public Product getProductById(int id) {
        Optional<Product> opt = productDao.findById(id);
        if(opt.isPresent()) {
            return opt.get();
        }
        return  null;
    }

    public Customer saveCustomer(Customer c) {
        return  customerDao.save(c);
    }

    public List<Customer> getCustomers() {
        return customerDao.findAll();
    }
}
