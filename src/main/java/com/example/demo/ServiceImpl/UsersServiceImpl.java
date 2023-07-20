package com.example.demo.ServiceImpl;

import com.example.demo.Model.Users;
import com.example.demo.Repository.UsersRepository;
import com.example.demo.Service.UsersService;
import com.example.demo.Response.SuccessResponse;
import com.example.demo.Response.PageResponse;
import com.example.demo.DTO.UsersDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
 import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Service
public class UsersServiceImpl implements UsersService { 

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public SuccessResponse getAllList() { 
        SuccessResponse successResponse = new SuccessResponse();
        List<UsersDTO> list = new ArrayList<>();
        List<Users> usersList = usersRepository.findAll();
        if(usersList.size() > 0) {
            usersList.forEach(users -> {
                list.add(modelMapper.map(users,UsersDTO.class));
            });
        }
        successResponse.setData(list);
        return successResponse;
    }


}