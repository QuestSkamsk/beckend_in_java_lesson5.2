package com.geekbrains.DZ6;

import com.geekbrains.db.model.Products;
import com.geekbrains.Utils.DbUtils;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UpdateProductTests extends ProductTest {

    @BeforeEach
    void createNewProductTest() throws IOException {
        Products newProduct = DbUtils.createNewProduct(productsMapper);
    }

    @DisplayName("Обновление продукта")
    @SneakyThrows
    @Test
    void updateProductTest() throws IOException {
        Integer countProductsBefore = DbUtils.countProducts(productsMapper);
        Products newProduct = DbUtils.updateProduct(productsMapper);
        Integer countProductsAfter = DbUtils.countProducts(productsMapper);
        assertThat(countProductsAfter, equalTo(countProductsBefore));
        assertThat(newProduct.getTitle(),equalTo("Table"));
        assertThat(newProduct.getCategory_id(),equalTo(3L));
        assertThat(newProduct.getPrice(),equalTo(115));
    }

    @AfterEach
    void tearDown() throws IOException {
        DbUtils.deleteProductByPrimaryKey();
    }

}