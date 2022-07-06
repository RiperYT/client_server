package com.example.demo.Dtos;

import java.math.BigDecimal;

public class StoreProductDto extends BaseDto{
    private String UPC;
    private int id_product;
    private BigDecimal selling_price;
    private int products_number;
    private boolean promotional_product;

    public StoreProductDto(){}

    public StoreProductDto(String UPC, int id_product, BigDecimal selling_price, int products_number, boolean promotional_product) {
        this.UPC = UPC;
        this.id_product = id_product;
        this.selling_price = selling_price;
        this.products_number = products_number;
        this.promotional_product = promotional_product;
    }

    public String getUPC() {
        return UPC;
    }

    public void setUPC(String UPC) {
        this.UPC = UPC;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public BigDecimal getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(BigDecimal selling_price) {
        this.selling_price = selling_price;
    }

    public int getProducts_number() {
        return products_number;
    }

    public void setProducts_number(int products_number) {
        this.products_number = products_number;
    }

    public boolean isPromotional_product() {
        return promotional_product;
    }

    public void setPromotional_product(boolean promotional_product) {
        this.promotional_product = promotional_product;
    }
}
