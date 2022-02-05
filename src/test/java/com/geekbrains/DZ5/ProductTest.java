package com.geekbrains.DZ5;

import com.geekbrains.DTO.Product;
import com.geekbrains.Enums.CategoryType;
import com.geekbrains.RestApi.CategoryService;
import com.geekbrains.RestApi.ProductService;
import com.geekbrains.Utils.RetrofitUtils;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import retrofit2.Retrofit;
import java.io.IOException;
public class ProductTest {

    static Retrofit client;
    static ProductService productService;
    static CategoryService categoryService;
    Faker faker = new Faker();
    Product product;

    @BeforeAll
    static void beforeAll() {
        client = RetrofitUtils.getRetrofit();
        productService = client.create(ProductService.class);
        categoryService = client.create(CategoryService.class);
    }
    @BeforeEach
    void setUp() throws IOException {
        product = new Product()
                .withTitle(faker.book().author())
                .withPrice((int) ((Math.random() + 1) * 100))
                .withCategoryTitle(CategoryType.FURNITURE.getTitle());
    }

}

