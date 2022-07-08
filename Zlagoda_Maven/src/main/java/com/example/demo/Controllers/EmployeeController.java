package com.example.demo.Controllers;

import com.example.demo.Dtos.BaseDto;
import com.example.demo.Dtos.EmployeeDto;
import com.example.demo.Repositories.EmployeeRepository;
import com.example.demo.Services.AuthenticationService;
import com.example.demo.Services.AuthorizationService;
import com.example.demo.Services.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final AuthorizationService authorizationService;
    private final AuthenticationService authenticationService;
    public EmployeeController(){
        this.employeeService = new EmployeeService(new EmployeeRepository());
        this.authorizationService = new AuthorizationService(new EmployeeRepository());
        this.authenticationService = new AuthenticationService(new EmployeeRepository());
    }

    //TODO
    @PostMapping("/delete")
    public ResponseEntity deleteUser(@RequestBody String str) {
        try{
            EmployeeDto baseDto = new ObjectMapper().readValue(str, EmployeeDto.class);
            if(authorizationService.AuthorizationManager(baseDto.getLogin(), baseDto.getPassword())) {
                if (employeeService.deleteEmployee(baseDto))
                    return ResponseEntity.ok("true");
                else
                    return ResponseEntity.ok("ErrorEdit");
            }
            else
                return ResponseEntity.ok("false");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    //TODO
    @PostMapping("/update")
    public ResponseEntity editUser(@RequestBody String str) {
        try{
            EmployeeDto baseDto = new ObjectMapper().readValue(str, EmployeeDto.class);
            if(authorizationService.AuthorizationManager(baseDto.getLogin(), baseDto.getPassword())) {
                if (employeeService.editEmployee(baseDto))
                    return ResponseEntity.ok("true");
                else
                    return ResponseEntity.ok("ErrorUpdate");
            }
            else
                return ResponseEntity.ok("false");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    
    //ready
    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody String str) throws JsonProcessingException {
        try{
            EmployeeDto baseDto = new ObjectMapper().readValue(str, EmployeeDto.class);
            if(authorizationService.AuthorizationManager(baseDto.getLogin(), baseDto.getPassword())) {
                if (employeeService.addEmployee(baseDto))
                    return ResponseEntity.ok("TrueAdd");
                else
                    return ResponseEntity.ok("ErrorAdd");
            }
            else
                return ResponseEntity.ok("ErrorAuthorization");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    //TODO
    @PostMapping("/getAllEmployee")
    public ResponseEntity getAllEmployee(@RequestBody String str) {
        try{
            BaseDto baseDto = new ObjectMapper().readValue(str, BaseDto.class);
            if(authorizationService.AuthorizationCashier(baseDto.getLogin(), baseDto.getPassword())
                    || authorizationService.AuthorizationManager(baseDto.getLogin(), baseDto.getPassword()))
                return ResponseEntity.ok(new JSONObject(employeeService.getAll()).toString());
            else
                return ResponseEntity.ok("ErrorAuthorization");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    //ready
    @PostMapping("/getInfo")
    public ResponseEntity getInfo(@RequestBody String str) {
        try{
            BaseDto baseDto = new ObjectMapper().readValue(str, BaseDto.class);
            if(authorizationService.AuthorizationCashier(baseDto.getLogin(), baseDto.getPassword())
                    || authorizationService.AuthorizationManager(baseDto.getLogin(), baseDto.getPassword()))
                return ResponseEntity.ok(new JSONObject(employeeService.getInfoById(baseDto.getLogin())).toString());
            else
                return ResponseEntity.ok("ErrorAuthorization");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    //ready
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody String str) {
        try{
            BaseDto baseDto = new ObjectMapper().readValue(str, BaseDto.class);
            if(authenticationService.Authentication(baseDto))
                return ResponseEntity.ok("true");
            else
                return ResponseEntity.ok("false");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}