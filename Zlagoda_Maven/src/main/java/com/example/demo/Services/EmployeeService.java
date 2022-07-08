package com.example.demo.Services;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.demo.Dtos.EmployeeDto;
import com.example.demo.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){this.employeeRepository = employeeRepository;}

    public EmployeeDto getInfoById(String id){
        return employeeRepository.infoEmployeeById(id);
    }

    public List<EmployeeDto> getAll(){

        try{ return employeeRepository.getAll(); }
        catch (Exception e) { throw e; }
    }

    public boolean addEmployee(EmployeeDto employeeDto){
        try{
            employeeRepository.addEmployee(employeeDto);
            return true;
        }catch (Exception e){
            throw e;
        }
    }

    public boolean editEmployee(EmployeeDto employeeDto){
        try{
            employeeRepository.editEmployee(employeeDto);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean deleteEmployee(EmployeeDto employeeDto){
        try{
            employeeRepository.deleteEmployee(employeeDto);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
