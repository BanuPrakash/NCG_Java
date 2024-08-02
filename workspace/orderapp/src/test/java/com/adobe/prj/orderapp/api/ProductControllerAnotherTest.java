package com.adobe.prj.orderapp.api;

import com.adobe.prj.orderapp.OrderappApplication;
import com.adobe.prj.orderapp.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Integration Test
@WebAppConfiguration
@AutoConfigureMockMvc
@SpringBootTest(classes = OrderappApplication.class)
public class ProductControllerAnotherTest {
    // can still mock OrderService

    TestRestTemplate template = new TestRestTemplate();
    // getForEntity, getForObject, postForEntity, ...

    @Test
    public void getProductTest() throws Exception {
        ResponseEntity<Product> response = template.getForEntity("http://localhost:8080/api/products/2", Product.class);
        assertEquals("200 OK", response.getStatusCode().toString());

        Product p = response.getBody();
        System.out.println(p);
        assertEquals("Samsung OLED", p.getName());
    }

}
