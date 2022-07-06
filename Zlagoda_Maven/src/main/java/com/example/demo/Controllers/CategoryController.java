package com.example.demo.Controllers;

import com.example.demo.Dtos.CategoryDto;
import com.example.demo.Dtos.EmployeeDto;
import com.example.demo.Services.AuthorizationService;
import com.example.demo.Services.CategoryService;
import com.example.demo.Services.EmployeeService;
import com.example.demo.Services.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
    IService service = new CategoryService();
    @PostMapping("/get")
    public ResponseEntity get(@RequestBody String str)
    {
        try{
        CategoryDto dto = new ObjectMapper().readValue(str, CategoryDto.class);
        if(new AuthorizationService().AuthorizationManager(dto.getLogin(), dto.getPassword())
                    || new AuthorizationService().AuthorizationCashier(dto.getLogin(), dto.getPassword()))
            return ResponseEntity.ok(new JSONObject(service.get(Integer.toString(dto.getCategory_number()))).toString());
        else
            return ResponseEntity.ok("false");
        } catch (Exception e) {
           return ResponseEntity.badRequest().body("Error");
        }
    }
    @PostMapping("/getAll")
    public ResponseEntity getAll(@RequestBody String str)
    {
        try{
            CategoryDto dto = new ObjectMapper().readValue(str, CategoryDto.class);
            if(new AuthorizationService().AuthorizationManager(dto.getLogin(), dto.getPassword())
                    || new AuthorizationService().AuthorizationCashier(dto.getLogin(), dto.getPassword())) {
                return ResponseEntity.ok(new JSONObject(service.getAll()).toString());
            }
            else
                return ResponseEntity.ok("false");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody String str)
    {
        try{
            CategoryDto dto = new ObjectMapper().readValue(str, CategoryDto.class);
            if(new AuthorizationService().AuthorizationManager(dto.getLogin(), dto.getPassword())) {
                if (service.add(dto))
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
    @PostMapping("/update")
    public ResponseEntity edit(@RequestBody String str)
    {
        try{
            CategoryDto dto = new ObjectMapper().readValue(str, CategoryDto.class);
            if(new AuthorizationService().AuthorizationManager(dto.getLogin(), dto.getPassword())) {
                if (service.edit(dto))
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
    @PostMapping("/delete")
    public ResponseEntity delete(@RequestBody String str)
    {
        try{
            CategoryDto dto = new ObjectMapper().readValue(str, CategoryDto.class);
            if(new AuthorizationService().AuthorizationManager(dto.getLogin(), dto.getPassword())) {
                if (service.delete(dto))
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
}
