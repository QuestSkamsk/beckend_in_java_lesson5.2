package com.geekbrains.DZ5;

import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.geekbrains.DTO.Product;
import com.geekbrains.Utils.Logger;
import retrofit2.Response;
import java.io.IOException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ProductByIdTest extends ProductTest{
    static Integer id;

    @BeforeEach
    void postProduct() throws IOException {
        Response<Product> response = productService.createProduct(product).execute();
        Logger.DEFAULT.log(response.body().toString());
        id = response.body().getId();
    }

    @DisplayName("Узнать id продукта")
    @SneakyThrows
    @Test
    void GetProductByIdTest() throws IOException {
        Response<Product> response = productService
                .getProduct(id)
                .execute();
        Logger.DEFAULT.log(response.body().toString());
        assertThat(response.body().getId(), equalTo(id));
        assertThat(response.code(), equalTo(200));;
    }

    @AfterEach
    void tearDown() throws IOException {
        Response<ResponseBody> response = productService.deleteProduct(id).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
    }

}
