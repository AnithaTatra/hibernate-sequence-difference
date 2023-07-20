package com.example.demo.ServiceImpl;

import com.example.demo.Model.Employee;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Service.EmployeeService;
import com.example.demo.DTO.EmployeeRequestDTO;
import com.example.demo.Response.SuccessResponse;
import com.example.demo.Response.PageResponse;
import com.example.demo.DTO.EmployeeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService { 

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public SuccessResponse getById(Integer id) {
        SuccessResponse successResponse = new SuccessResponse();
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            EmployeeDTO employeeDTO = modelMapper.map(employeeOptional, EmployeeDTO.class);
            successResponse.setData(employeeDTO);
        } else {
            throw new RuntimeException("Id not Found Exception");
        }
        return successResponse;
    }

    @Override
    public SuccessResponse save(EmployeeRequestDTO employeeRequestDTO) {
        SuccessResponse successResponse = new SuccessResponse();
        Employee employee = null ;
        if (employeeRequestDTO.getEId() == null) {
            employee = new Employee();
        } else {
            Optional<Employee> employeeOptional = employeeRepository.findById(employeeRequestDTO.getEId());
            if (employeeOptional.isPresent()) {
                employee = employeeOptional.get();
            } else {
                throw new RuntimeException("Id not Found Exception");
            }
        }
        modelMapper.map(employeeRequestDTO,employee.getClass());
        employeeRepository.save(employee);
        successResponse.setData("Data Saved Successfully");
        return successResponse;
    }


}