package com.adobe.prj.orderapp.api;

import com.adobe.prj.orderapp.entity.Product;
import com.adobe.prj.orderapp.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

    /*
      @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //201
    public Product addProduct(@RequestBody @Valid  Product p) {
        return service.addProduct(p);
    }
     */
    @Test
    public void addProductTest() throws  Exception {
        Product p = Product.builder().name("A").price(1200).quantity(100).build();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(p); // Product --> JSON
        // mocking
        when(service.addProduct(Mockito.any(Product.class))).thenReturn(Mockito.any(Product.class));

        mockMvc.perform(post("/api/products")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        verify(service, times(1)).addProduct(Mockito.any(Product.class));
    }

    @Test
    public void addProductExceptionTest() throws  Exception {
        Product p = Product.builder().name("").price(-1200).quantity(0).build();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(p); // Product --> JSON
        // mocking no need
       // when(service.addProduct(Mockito.any(Product.class))).thenReturn(Mockito.any(Product.class));

        mockMvc.perform(post("/api/products")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))

                .andExpect(jsonPath("$.errors", hasSize(3)))
                .andExpect(jsonPath("$.errors", hasItem("Name is required")))
                .andExpect(jsonPath("$.errors", hasItem("Quantity 0 should be more than 1")))
                .andExpect(status().isNotFound());;

                verifyNoInteractions(service);
       // verify(service, times(1)).addProduct(Mockito.any(Product.class));
    }
}
