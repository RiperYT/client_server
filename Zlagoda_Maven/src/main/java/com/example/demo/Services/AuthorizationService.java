package com.example.demo.Services;

import com.example.demo.Dtos.BaseDto;
import com.example.demo.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthorizationService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public AuthorizationService(EmployeeRepository employeeRepository){this.employeeRepository = employeeRepository;}
    public boolean AuthorizationManager(String login, String password){
        return employeeRepository.IsManager(login, password);
    }
    public boolean AuthorizationCashier(String login, String password){
        return employeeRepository.IsCashier(login, password);
    }
}
