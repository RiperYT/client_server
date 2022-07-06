package com.example.demo.Services;

import com.example.demo.Dtos.EmployeeDto;
import com.example.demo.Repositories.EmployeeRepository;

import java.util.List;

public class EmployeeService {

    public EmployeeDto getInfoById(String id){
        return new EmployeeRepository().infoEmployeeById(id);
    }

    public List<EmployeeDto> getAll(){
        return new EmployeeRepository().getAll();
    }

    public boolean addEmployee(EmployeeDto employeeDto){
        try{
            new EmployeeRepository().addEmployee(employeeDto);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean editEmployee(EmployeeDto employeeDto){
        try{
            new EmployeeRepository().editEmployee(employeeDto);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean deleteEmployee(EmployeeDto employeeDto){
        try{
            new EmployeeRepository().deleteEmployee(employeeDto);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
