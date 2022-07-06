package com.example.demo.Services;

import com.example.demo.Dtos.BaseDto;
import com.example.demo.Repositories.EmployeeRepository;

public class AuthenticationService {

    public boolean Authentication(BaseDto entity){
        return new EmployeeRepository().Login(entity.getLogin(), entity.getPassword());
    }

}
