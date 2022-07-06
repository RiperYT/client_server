package com.example.demo.Services;

import com.example.demo.Dtos.ProductDto;
import com.example.demo.Repositories.CategoryRepository;
import com.example.demo.Repositories.ProductRepository;

import java.util.List;

public class ProductService implements IService<ProductDto>{
    ProductRepository repository;
    @Override
    public ProductDto get(String id) {
        return repository.get();
    }

    @Override
    public List<ProductDto> getAll() {
        return repository.getAll();
    }

    @Override
    public boolean add(ProductDto dto) {
        try{
            repository.add(dto);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean edit(ProductDto dto) {
        try{
            repository.edit(dto);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean delete(ProductDto dto) {
        try{
            repository.delete(dto);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
