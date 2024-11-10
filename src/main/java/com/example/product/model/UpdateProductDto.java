package com.example.product.model;

public class UpdateProductDto {
    private Long id; // Incluye el ID si es necesario para la actualización
    private String name; // Opcional, dependiendo de si deseas actualizar el nombre
    private String description; // Opcional
    private Double price; // Opcional

    // Constructor vacío
    public UpdateProductDto() {}

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
