package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.ServiceImpl.EmployeeServiceImpl;
import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.Model.Employee;
import com.example.demo.DTO.EmployeeRequestDTO;

import com.example.demo.Repository.UsersRepository;
import com.example.demo.ServiceImpl.UsersServiceImpl;
import com.example.demo.DTO.UsersDTO;
import com.example.demo.Model.Users;

import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;

@SpringBootTest
class DemoApplicationTests {
    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    UsersServiceImpl usersService;
    @Mock
    UsersRepository usersrepository;

    @InjectMocks
    EmployeeServiceImpl employeeService;
    @Mock
    EmployeeRepository employeerepository;

    @Test
    public void getUsersAllListOfDataS() {
        when(usersrepository.findAll( )).thenReturn((getUsersAllListOfData( )));
        assertNotNull(usersService.getAllList( ));
    }


    @Test
    public void getEmployeeById() {
        when(employeerepository.findById(any( ))).thenReturn(Optional.ofNullable(employeeListOfData( )));
        when(modelMapper.map(any( ), any( ))).thenReturn(EmployeeMasterDto( ));
        int id = 1;
        assertNotNull(employeeService.getById(id));
    }

    @Test
    public void getEmployeeSaveData() {
        when(employeerepository.findById(any( ))).thenReturn(Optional.ofNullable(employeeListOfData( )));
        when(employeerepository.save(any( ))).thenReturn((employeeListOfData( )));
        assertNotNull(employeeService.save(employeeRequestDTO( )));
    }


    @Test
    void contextLoads() {
    }

    public EmployeeDTO EmployeeMasterDto() {
        List<EmployeeDTO> employeeDtoList = new ArrayList<>( );
        EmployeeDTO employeeDTO = new EmployeeDTO( );
        employeeDTO.setEId(1);
        employeeDTO.setEName("");
        employeeDtoList.add(employeeDTO);
        return employeeDTO;
    }

    public Employee employeeListOfData() {
        Employee employee = new Employee( );
        employee.setEId(1);
        employee.setEName("");
        return employee;
    }

    public EmployeeRequestDTO employeeRequestDTO() {
        List<EmployeeRequestDTO> employeeRequestDTOList = new ArrayList<>( );
        EmployeeRequestDTO employeeRequestDTO = new EmployeeRequestDTO( );
        employeeRequestDTO.setEId(1);
        employeeRequestDTO.setEName("");
        employeeRequestDTOList.add(employeeRequestDTO);
        return employeeRequestDTO;
    }


    public UsersDTO UsersMasterDto() {
        List<UsersDTO> usersDtoList = new ArrayList<>( );
        UsersDTO usersDTO = new UsersDTO( );
        usersDTO.setUId(1);
        usersDTO.setUName("");
        usersDtoList.add(usersDTO);
        return usersDTO;
    }

    public Users usersListOfData() {
        Users users = new Users( );
        users.setUId(1);
        users.setUName("");
        return users;
    }

    public List<Users> getUsersAllListOfData() {
        List<Users> usersList = new ArrayList<>( );
        Users users = new Users( );
        users.setUId(1);
        users.setUName("");
        usersList.add(users);
        return usersList;
    }


}