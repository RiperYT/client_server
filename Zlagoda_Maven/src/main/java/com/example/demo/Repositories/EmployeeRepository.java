package com.example.demo.Repositories;

import java.sql.Date;
import com.example.demo.Dtos.BaseDto;
import com.example.demo.Dtos.EmployeeDto;
import com.example.demo.Dtos.EmployeeMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.ArrayList;

public class EmployeeRepository extends BaseRepository{

    public EmployeeRepository(/*JdbcTemplate jdbcTemplate*/){
    }

    public boolean Login(String login, String password){
        EmployeeDto result = jdbcTemplate.query("SELECT * FROM \"Employee\" WHERE id_employee=? AND password=?", new Object[]{login, password}, new EmployeeMapper()).stream().findAny().orElse(null);
        return result != null;
    }
    public boolean IsManager(String login, String password){
        EmployeeDto result = jdbcTemplate.query("SELECT * FROM \"Employee\" WHERE id_employee=? AND password=? AND empl_role='Manager'", new Object[]{login, password}, new EmployeeMapper()).stream().findAny().orElse(null);
        return result != null;
    }
    public boolean IsCashier(String login, String password){
        EmployeeDto result = jdbcTemplate.query("SELECT * FROM \"Employee\" WHERE id_employee=? AND password=?",
                                                                new Object[]{login, password},
                                                                new EmployeeMapper()).stream()
                                         .findAny().orElse(null);
        return result.getEmpl_role().equals("Cashier");
    }

    public EmployeeDto infoEmployeeById(String id){
        return jdbcTemplate.query("SELECT * FROM \"Employee\" WHERE id_employee=?",
                        new Object[]{id},
                        new EmployeeMapper()).stream()
                .findAny().orElse(null);
    }

    public List<EmployeeDto> getAll(){
        return jdbcTemplate.query("SELECT * FROM \"Employee\"",
                        new EmployeeMapper());
    }

    public void addEmployee(EmployeeDto employeeDto){
        List<EmployeeDto> dtos = getAll();
        List<String> ids = new ArrayList<String>();
        for (EmployeeDto dto : dtos) {
            ids.add(dto.getId_employee());
        }
        String id = Generate(10, ids);
        jdbcTemplate.update("INSERT INTO \"Employee\" VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)",
                id,
                employeeDto.getEmpl_surname(),
                employeeDto.getEmpl_name(),
                employeeDto.getEmpl_patronymic(),
                employeeDto.getEmpl_role(),
                employeeDto.getSalary(),
                Date.valueOf(employeeDto.getDate_of_birth()),
                Date.valueOf(employeeDto.getDate_of_start()),
                employeeDto.getPhone_number(),
                employeeDto.getCity(),
                employeeDto.getStreet(),
                employeeDto.getZip_code(),
                employeeDto.getPasswordEmployee());
    }

    public void editEmployee(EmployeeDto employeeDto){}

    public void deleteEmployee(EmployeeDto employeeDto){}
}
