package com.example.demo.Service;

import com.example.demo.Response.SuccessResponse;
import com.example.demo.Response.PageResponse;
import org.springframework.stereotype.Service;

@Service
public interface UsersService {

    SuccessResponse getAllList();

}