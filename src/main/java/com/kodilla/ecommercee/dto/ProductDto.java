package com.kodilla.ecommercee.dto;

public class ProductDto {
    private int id;
    private String name;
    private  String description;
    private int price;
    private String groupId;
    public ProductDto() {
    }

    public ProductDto(int id, String name, String description, int price, String groupId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.groupId = groupId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String getGroupId() {
        return groupId;
    }
}
