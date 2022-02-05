package com.geekbrains.DZ5;

import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.geekbrains.DTO.Product;
import com.geekbrains.Utils.Logger;
import retrofit2.Response;


import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateProductTest extends ProductTest {
    static Integer id;

    @DisplayName("Создание продукта")
    @SneakyThrows
    @Test
    void postProductTest() throws IOException {
        Response<Product> response = productService.createProduct(product).execute();
        Logger.DEFAULT.log(response.body().toString());
        id = response.body().getId();
        assertThat(response.body().getTitle(), equalTo(product.getTitle()));
        assertThat(response.body().getPrice(), equalTo(product.getPrice()));
        assertThat(response.body().getCategoryTitle(), equalTo(product.getCategoryTitle()));
        assertThat(response.code(), equalTo(201));
    }

    @AfterEach
    void tearDown() throws IOException {
        Response<ResponseBody> response = productService.deleteProduct(id).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
    }
}
