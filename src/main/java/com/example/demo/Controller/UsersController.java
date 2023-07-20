package com.example.demo.Controller;

import com.example.demo.Response.SuccessResponse;
import com.example.demo.Response.PageResponse;
import com.example.demo.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController { 

    @Autowired
    private UsersService usersService;

    @GetMapping("/getAll")
    public SuccessResponse getAllList() {
        return usersService.getAllList();
    }

}