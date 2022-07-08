package com.example.demo.Dtos;

import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<EmployeeDto> {

    @Override
    public EmployeeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmployeeDto dto = new EmployeeDto();
        dto.setId_employee(rs.getString("id_employee"));
        dto.setEmpl_surname(rs.getString("empl_surname"));
        dto.setEmpl_name(rs.getString("empl_name"));
        dto.setEmpl_patronymic(rs.getString("empl_patronymic"));
        dto.setEmpl_role(rs.getString("empl_role"));
        dto.setSalary(rs.getBigDecimal("salary"));
        dto.setDate_of_birth(rs.getDate("date_of_birth").toString());
        dto.setDate_of_start(rs.getDate("date_of_start").toString());
        dto.setPhone_number(rs.getString("phone_number"));
        dto.setCity(rs.getString("city"));
        dto.setStreet(rs.getString("street"));
        dto.setZip_code(rs.getString("zip_code"));
        dto.setPasswordEmployee(rs.getString("password"));
        return dto;
    }
}
