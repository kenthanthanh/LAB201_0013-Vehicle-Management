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
public class Motorbike extends Vehicle implements Serializable {

    private double speed;
    private boolean requiresLicense;

    public Motorbike(String id, String name, String color, double price, String brand, double speed, boolean requiresLicense) {
        super(id, name, color, price, brand);
        this.speed = speed;
        this.requiresLicense = requiresLicense;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public boolean getRequiresLicense() {
        return requiresLicense;
    }

    public void setRequiresLicense(boolean requiresLicense) {
        this.requiresLicense = requiresLicense;
    }
@Override
    public String toString() {
        return "Motorbike" + "    " + getId() + "    " + getName() + "    " + getColor() + "    " + getPrice() + "    " + getBrand() + "    " + getSpeed() + "    " + getRequiresLicense();
    }
//    @Override
//    public void toStringInfo() {
//      System.out.printf("%-9s\t%-10s\t%-20s\t%-10s\t%-5f\t%-10s\t%-10.2f\t%-12b\n",
//                "Motorbike", getId(), getName(), getColor(), getPrice(), getBrand(), getSpeed(), getRequiresLicense());
//    }
    
    public void makeSound()
    {
        System.out.println("Tin tin tin...");
    }

    @Override
    public String getFileLineFormat() {
        return "Motorbike"+ ","+ getId() + "," + getName() + "," + getColor() + "," + getPrice() + "," + getBrand() + "," + getSpeed() + "," + getRequiresLicense();

    }

}
