package com.example.demo.Services;

import com.example.demo.Dtos.BaseDto;
import com.example.demo.Repositories.EmployeeRepository;

public class AuthorizationService {

    public boolean AuthorizationManager(String login, String password){
        EmployeeRepository employeeRepository = new EmployeeRepository();
        return employeeRepository.IsManager(login, password);
    }
    public boolean AuthorizationCashier(String login, String password){
        EmployeeRepository employeeRepository = new EmployeeRepository();
        return employeeRepository.IsCashier(login, password);
    }
}
