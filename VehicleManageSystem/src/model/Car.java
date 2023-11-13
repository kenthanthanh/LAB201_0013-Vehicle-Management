/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

public class Car extends Vehicle implements Serializable {

    private String type;
    private int yearOfManufacture;

    public Car(String id, String name, String color, double price, String brand, String type, int yearOfManufacture) {
        super(id, name, color, price, brand);
        this.type = type;
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }
    
   @Override
    public String toString() {
            return "Car" + "    " + getId() + "    " + getName() + "    " + getColor() + "    " + getPrice() + "    "+ getBrand() + "    "+ getType() + "    "+ getYearOfManufacture();
    }
//    @Override
//    public void toStringInfo() {
//        System.out.printf("%-9s\t%-10s\t%-20s\t%-10s\t%-5f\t%-10s\t%-10s\t%-12d\n",
//                "Car", getId(), getName(), getColor(), getPrice(), getBrand(), getType(), getYearOfManufacture());
//    }

    @Override
    public String getFileLineFormat() {            
        return "Car" + ","+ getId() + "," + getName() + "," + getColor() + "," + getPrice() + ","+ getBrand() + ","+ getType() + ","+ getYearOfManufacture();
    }
}

