package com.store.springecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
    private int statusCode;
    private String message;
    private Object data;
}
