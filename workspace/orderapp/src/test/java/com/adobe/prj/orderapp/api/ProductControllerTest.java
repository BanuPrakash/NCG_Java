package com.adobe.prj.orderapp.api;

import com.adobe.prj.orderapp.entity.Product;
import com.adobe.prj.orderapp.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @MockBean
    private OrderService service;

    @Autowired
    MockMvc mockMvc; // used to perform CRUD operations GET / POST / PUT / DELETE

    // GET http://localhost:8080/api/products
    @Test
    public void getProductsTest() throws Exception {
        // Mock data
        List<Product> products = Arrays.asList(
                Product.builder().id(22).name("A").price(1003).quantity(44).build(),
                Product.builder().id(45).name("B").price(631).quantity(100).build()
        );
        // mocking
        when(service.getProducts()).thenReturn(products);

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(22)))
                .andExpect(jsonPath("$[1].name", is("B")));

        verify(service, times(1)).getProducts();

    }
}
