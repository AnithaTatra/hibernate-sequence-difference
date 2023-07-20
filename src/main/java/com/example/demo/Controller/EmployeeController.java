package com.example.demo.Controller;

import com.example.demo.Response.SuccessResponse;
import com.example.demo.Response.PageResponse;
import com.example.demo.Service.EmployeeService;
import com.example.demo.DTO.EmployeeRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController { 

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public SuccessResponse save(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
        return employeeService.save(employeeRequestDTO);
    }


    @GetMapping("/getById")
    public SuccessResponse getById(@RequestParam("id") Integer id) {
        return employeeService.getById(id);
    }

}