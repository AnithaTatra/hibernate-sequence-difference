package com.example.demo.Service;

import com.example.demo.DTO.EmployeeRequestDTO;
import com.example.demo.Response.SuccessResponse;
import com.example.demo.Response.PageResponse;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    SuccessResponse save(EmployeeRequestDTO employeeRequestDTO);

    SuccessResponse getById(Integer id);

}