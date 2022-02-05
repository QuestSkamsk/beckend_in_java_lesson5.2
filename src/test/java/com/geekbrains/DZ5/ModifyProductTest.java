package com.geekbrains.DZ5;

import com.geekbrains.DTO.Product;
import com.geekbrains.Enums.CategoryType;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.geekbrains.Utils.Logger;
import retrofit2.Response;
import java.io.IOException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ModifyProductTest extends ProductTest{
    Integer id;

    @BeforeEach
    void postProduct() throws IOException {
        Response<Product> response = productService.createProduct(product).execute();
        Logger.DEFAULT.log(response.body().toString());
        id = response.body().getId();
    }

    @DisplayName("Изменить продукт")
    @SneakyThrows
    @Test
    void modifyProductTest() throws IOException {
        Response<Product> response = productService.modifyProduct(product
                        .withId(id)
                        .withTitle("Table")
                        .withCategoryTitle(CategoryType.FURNITURE.getTitle())
                        .withPrice(155))
                .execute();
        Logger.DEFAULT.log(response.body().toString());
        assertThat(response.body().getTitle(), equalTo("Table"));
        assertThat(response.body().getPrice(), equalTo(155));
        assertThat(response.body().getCategoryTitle(), equalTo(product.getCategoryTitle()));
        assertThat(response.code(), equalTo(200));
    }

    @DisplayName("Не верная категория")
    @SneakyThrows
    @Test
    void modifyProductWrongCategoryTypeTest() throws IOException {
        Response<Product> response = productService.modifyProduct(product
                        .withId(id)
                        .withTitle("Table")
                        .withCategoryTitle(CategoryType.BOOK.getTitle())
                        .withPrice(155))
                .execute();
        assertThat(response.code(), equalTo(500));
    }

    @DisplayName("Не верный id")
    @SneakyThrows
    @Test
    void modifyProductWrongIdTest() throws IOException {
        Response<Product> response = productService.modifyProduct(product
                        .withId(0)
                        .withTitle("Table")
                        .withCategoryTitle(CategoryType.FURNITURE.getTitle())
                        .withPrice(155))
                .execute();
        assertThat(response.code(), equalTo(400));
    }

    @AfterEach
    void tearDown() throws IOException {
        Response<ResponseBody> response = productService.deleteProduct(id).execute();
    }
}
