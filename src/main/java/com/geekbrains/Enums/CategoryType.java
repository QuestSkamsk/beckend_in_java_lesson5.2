package com.geekbrains.Enums;

import lombok.Getter;

public enum CategoryType {

    FURNITURE("Furniture", 3),
    BOOK("book", 4);

    @Getter
    private final String title;
    @Getter
    private final Integer id;

    CategoryType(String title, Integer id) {
        this.title = title;
        this.id = id;
    }
}

