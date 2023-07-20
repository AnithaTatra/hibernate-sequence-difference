package com.example.demo.Response;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuccessResponse<T> { 

    private int statusCode = 200;
    private String statusMessage = "Success";
    private T data;

}
