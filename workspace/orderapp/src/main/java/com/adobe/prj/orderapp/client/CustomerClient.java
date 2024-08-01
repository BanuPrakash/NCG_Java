package com.adobe.prj.orderapp.client;

import com.adobe.prj.orderapp.entity.Customer;
import com.adobe.prj.orderapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Order(2)
public class CustomerClient implements CommandLineRunner {
    private final OrderService service;
    @Override
    public void run(String... args) throws Exception {
        addCustomer();
    }

    private void addCustomer() {
       if(service.getCustomerCount() == 0) {
           service.saveCustomer(Customer.builder().
                   email("sam@adobe.com").
                   firstName("Sam")
                   .lastName("Peter").build());
           service.saveCustomer(Customer.builder().
                   email("rita@adobe.com").
                   firstName("Rita")
                   .lastName("John").build());
       }
    }
}
