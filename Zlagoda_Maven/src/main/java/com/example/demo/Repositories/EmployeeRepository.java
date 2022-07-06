package com.example.demo.Repositories;

import com.example.demo.Dtos.EmployeeDto;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class EmployeeRepository {
    public boolean Login(String login, String password){
        return true;
    }
    public boolean IsManager(String login, String password){
        return true;
    }
    public boolean IsCashier(String login, String password){
        return true;
    }

    public EmployeeDto infoEmployeeById(String id){
        return new EmployeeDto();
    }
    public List<EmployeeDto> getAll(){
        List<EmployeeDto> list = null;
        list.add(new EmployeeDto());
        return list;
    }

    public void addEmployee(EmployeeDto employeeDto){}

    public void editEmployee(EmployeeDto employeeDto){}

    public void deleteEmployee(EmployeeDto employeeDto){}
}
