package com.geekbrains.DZ5;

import com.geekbrains.DTO.Product;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.geekbrains.Utils.Logger;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DeleteProductTest extends ProductTest{
    Integer id;

    @BeforeEach
    void postProduct() throws IOException {
        Response<Product> response = productService.createProduct(product).execute();
        Logger.DEFAULT.log(response.body().toString());
        id = response.body().getId();
    }

    @DisplayName("Удалить продукт")
    @SneakyThrows
    @Test
    void deleteProductTest() throws IOException {
        Response<ResponseBody> response = productService.deleteProduct(id).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.code(), equalTo(200));
    }

    @DisplayName("Нельзя восстановить продукт поле удаления")
    @Test
    void getProductsWrongMethod() throws IOException {
        Response<ArrayList<Product>> response = productService
                .getProductsWrongMethod()
                .execute();
        assertThat(response.code(), equalTo(405));
    }
}
