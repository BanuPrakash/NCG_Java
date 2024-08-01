package com.adobe.prj.orderapp.client;

import com.adobe.prj.orderapp.entity.Customer;
import com.adobe.prj.orderapp.entity.LineItem;
import com.adobe.prj.orderapp.entity.Order;
import com.adobe.prj.orderapp.entity.Product;
import com.adobe.prj.orderapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderClient implements CommandLineRunner {
    private  final OrderService service;

    @Override
    public void run(String... args) throws Exception {
        placeOrder();
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
    private void placeOrder() {
        Order order = new Order();
        order.setCustomer(Customer.builder().email("sam@adobe.com").build());
        List<LineItem> items = new ArrayList<>();
            LineItem i1 = LineItem.builder().product(Product.builder().id(3).build()).qty(2).build();
            LineItem i2 = LineItem.builder().product(Product.builder().id(1).build()).qty(1).build();
            items.add(i1);
            items.add(i2);
        order.setItems(items);
        service.placeOrder(order);
    }
}
