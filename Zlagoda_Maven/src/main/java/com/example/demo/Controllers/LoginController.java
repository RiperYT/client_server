package com.example.demo.Controllers;

import com.example.demo.Dtos.BaseDto;
import com.example.demo.Dtos.EmployeeDto;
import com.example.demo.Services.AuthenticationService;
import com.example.demo.Services.AuthorizationService;
import com.example.demo.Services.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class LoginController {

    @PostMapping("/delete")
    public ResponseEntity deleteUser(@RequestBody String str) {
        try{
            EmployeeDto baseDto = new ObjectMapper().readValue(str, EmployeeDto.class);
            if(new AuthorizationService().AuthorizationManager(baseDto.getLogin(), baseDto.getPassword())) {
                if (new EmployeeService().deleteEmployee(baseDto))
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

    @PostMapping("/update")
    public ResponseEntity editUser(@RequestBody String str) {
        try{
            EmployeeDto baseDto = new ObjectMapper().readValue(str, EmployeeDto.class);
            if(new AuthorizationService().AuthorizationManager(baseDto.getLogin(), baseDto.getPassword())) {
                if (new EmployeeService().editEmployee(baseDto))
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

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody String str) {
        try{
            EmployeeDto baseDto = new ObjectMapper().readValue(str, EmployeeDto.class);
            if(new AuthorizationService().AuthorizationManager(baseDto.getLogin(), baseDto.getPassword())) {
                if (new EmployeeService().addEmployee(baseDto))
                    return ResponseEntity.ok("true");
                else
                    return ResponseEntity.ok("ErrorAdd");
            }
            else
                return ResponseEntity.ok("false");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PostMapping("/getAllEmployee")
    public ResponseEntity getAllEmployee(@RequestBody String str) {
        try{
            BaseDto baseDto = new ObjectMapper().readValue(str, BaseDto.class);
            AuthorizationService service = new AuthorizationService();
            if(service.AuthorizationCashier(baseDto.getLogin(), baseDto.getPassword())
                    || service.AuthorizationManager(baseDto.getLogin(), baseDto.getPassword()))
                return ResponseEntity.ok(new JSONObject(new EmployeeService().getAll()).toString());
            else
                return ResponseEntity.ok("false");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PostMapping("/getInfo")
    public ResponseEntity getInfo(@RequestBody String str) {
        try{
            BaseDto baseDto = new ObjectMapper().readValue(str, BaseDto.class);
            AuthorizationService service = new AuthorizationService();
            if(service.AuthorizationCashier(baseDto.getLogin(), baseDto.getPassword())
                    || service.AuthorizationManager(baseDto.getLogin(), baseDto.getPassword()))
                return ResponseEntity.ok(new JSONObject(new EmployeeService().getInfoById(baseDto.getLogin())).toString());
            else
                return ResponseEntity.ok("false");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PostMapping("/login")
    public ResponseEntity postSuccess(@RequestBody String str) {
        try{
            BaseDto baseDto = new ObjectMapper().readValue(str, BaseDto.class);
            if(new AuthenticationService().Authentication(baseDto))
                return ResponseEntity.ok("true");
            else
                return ResponseEntity.ok("false");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}