package com.example.demo.Dtos;

public class ProductDto extends BaseDto{
    private int id_product;
    private String category_name;
    private String category_number;
    private String product_name;
    private String characteristics;
    public ProductDto(){}
    public ProductDto(int id_product, String category_name, String category_number, String product_name, String characteristics) {
        this.id_product = id_product;
        this.category_name = category_name;
        this.category_number = category_number;
        this.product_name = product_name;
        this.characteristics = characteristics;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_number() {
        return category_number;
    }

    public void setCategory_number(String category_number) {
        this.category_number = category_number;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }
}
