package com.geekbrains.DZ6;

import com.geekbrains.db.model.Categories;
import com.geekbrains.Utils.DbUtils;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DeleteCategoriesTests extends ProductTest {

    @BeforeEach
    void createCategoryPositiveTest() throws IOException {
        Categories newCategory = DbUtils.createNewCategory(categoriesMapper);
    }

    @DisplayName("Удаление категории")
    @SneakyThrows
    @Test
    void deleteCategoryByPrimaryKeyTest() throws IOException {
        Integer countCategoriesBefore = DbUtils.countCategories(categoriesMapper);
        DbUtils.deleteCategoryByPrimaryKey();
        Integer countCategoriesAfter = DbUtils.countCategories(categoriesMapper);
        assertThat(countCategoriesAfter, equalTo(countCategoriesBefore - 1));
    }
}
