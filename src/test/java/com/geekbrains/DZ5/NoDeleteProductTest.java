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

public class NoDeleteProductTest extends ProductTest{
        Integer id;

        @BeforeEach
        void postProduct() throws IOException {
            Response<Product> response = productService.createProduct(product).execute();
            Logger.DEFAULT.log(response.body().toString());
            id = response.body().getId();
        }

        @DisplayName("Нельзя удалить продукт без id")
        @SneakyThrows
        @Test
        void deleteProductWrongIdTest() throws IOException {
            Response<ResponseBody> response = productService.deleteProduct(0).execute();
            assertThat(response.isSuccessful(), CoreMatchers.is(false));
            assertThat(response.code(), equalTo(500));
        }

        @AfterEach
        void tearDown() throws IOException {
            Response<ResponseBody> response = productService.deleteProduct(id).execute();
            assertThat(response.isSuccessful(), CoreMatchers.is(true));
        }
}
