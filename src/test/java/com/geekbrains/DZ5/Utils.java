/*package com.geekbrains.DZ5;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import com.geekbrains.DTO.GetCategoryResponse;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class Utils {

    @Test
    void test() throws IOException {
        GetCategoryResponse getCategoryResponse = new GetCategoryResponse();
        getCategoryResponse.setId(1);
        getCategoryResponse.setTitle("myTitle");

        StringWriter writer = new StringWriter();

        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(writer.getCategoryResponse);

        String result = writer.toString();
        System.out.println(result);

        StringReader reader = new StringReader(result);

        GetCategoryResponse getCategoryResponseReader = mapper.readValue(reader, GetCategoryResponse.class);

    }

}*/
