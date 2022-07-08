package com.example.demo.Services;

import com.example.demo.Dtos.BaseDto;
import com.example.demo.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthenticationService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public AuthenticationService(EmployeeRepository employeeRepository){this.employeeRepository = employeeRepository;}
    public boolean Authentication(BaseDto entity){
        return employeeRepository.Login(entity.getLogin(), entity.getPassword());
    }

}
