package com.example.demo.Services;

import com.example.demo.Dtos.CategoryDto;
import com.example.demo.Repositories.CategoryRepository;
import com.example.demo.Repositories.EmployeeRepository;

import java.util.List;

public class CategoryService implements IService<CategoryDto> {
    CategoryRepository repository;
    @Override
    public CategoryDto get(String id) {
        return repository.get();
    }

    @Override
    public List<CategoryDto> getAll() {
        return repository.getAll();
    }

    @Override
    public boolean add(CategoryDto dto) {
        try{
            repository.add(dto);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean edit(CategoryDto dto) {
        try{
            repository.edit(dto);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean delete(CategoryDto dto) {
        try{
            repository.delete(dto);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
