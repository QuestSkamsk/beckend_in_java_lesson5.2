package com.geekbrains.DZ5;

import com.geekbrains.DTO.Product;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import java.io.IOException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class NotFoundByIdProductTest extends ProductTest{
    @BeforeEach
    void setUpWithoutCategory() throws IOException {
        product = new Product()
                .withTitle(faker.book().author())
                .withPrice((int) ((Math.random() + 1) * 100));
    }

    @DisplayName("Нельзя создать продукт без категории")
    @SneakyThrows
    @Test
    void postProductWithoutCategoryTest() throws IOException {
        Response<Product> response = productService.createProduct(product).execute();
        assertThat(response.code(), equalTo(500));
    }

    @DisplayName("Продукт с id=0 нельзя создать")
    @SneakyThrows
    @Test
    void postProductWithIdTest() throws IOException {
        Response<Product> response = productService.createProduct(product.withId(0)).execute();
        assertThat(response.code(), equalTo(400));
    }

    @DisplayName("Не нашли по id")
    @SneakyThrows
    @Test
    void GetProductByIdTest() throws IOException {
        Response<Product> response = productService
                .getProduct(0)
                .execute();
        assertThat(response.code(), equalTo(404));;
    }
}
