/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;


/**
 *
 * @author kei ti ti
 */
public abstract class Vehicle implements Serializable{

    private String id;
    private String name;
    private String color;
    private double price;
    private String brand;

    public Vehicle(String id, String name, String color, double price, String brand) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.price = price;
        this.brand = brand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Vehicle [id=" + id + ", name=" + name + ", color=" + color + ", price=" + price + ", brand=" + brand
                + "]";
    }

    public abstract String getFileLineFormat();

}
