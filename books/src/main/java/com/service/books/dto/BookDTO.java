package com.service.books.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class BookDTO<T> {

    private Boolean status;

    private List<String> message = new ArrayList<>();

    private T payloads;
}
