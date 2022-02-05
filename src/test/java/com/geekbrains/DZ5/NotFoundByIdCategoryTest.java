package com.geekbrains.DZ5;

import com.geekbrains.DTO.GetCategoryResponse;
import com.geekbrains.Enums.CategoryType;
import lombok.SneakyThrows;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.geekbrains.Utils.Logger;
import retrofit2.Response;
import java.io.IOException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class NotFoundByIdCategoryTest extends ProductTest{
    Integer id = CategoryType.FURNITURE.getId();
    Integer idWrong = CategoryType.BOOK.getId();

    @DisplayName("Найти по id")
    @SneakyThrows
    @Test
    void getCategoryByIdTest() throws IOException {
        Response<GetCategoryResponse> response = categoryService
                .getCategory(id)
                .execute();
        Logger.DEFAULT.log(response.body().toString());
        assertThat(response.body().getTitle(), equalTo(CategoryType.FURNITURE.getTitle()));
        assertThat(response.body().getId(), equalTo(id));
        response.body().getProducts().forEach(product ->
                assertThat(product.getCategoryTitle(), equalTo("Furniture")));
    }

    @DisplayName("Не верный id")
    @SneakyThrows
    @Test
    void GetCategoryByIdTest() throws IOException {
        Response<GetCategoryResponse> response = categoryService
                .getCategory(idWrong)
                .execute();
        assertThat(response.body(), equalTo(null));
        assertThat(response.isSuccessful(), CoreMatchers.is(false));
        assertThat(response.code(), equalTo(404));
    }
}
