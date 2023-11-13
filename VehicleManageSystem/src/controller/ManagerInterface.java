/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Vehicle;



/**
 *
 * @author kei ti ti
 */
public interface ManagerInterface {
    public void loadData();
    public void storeData();
    public void add();
    public void update();
    public void delete();
    public void search();
    public void show();
    public ArrayList<Vehicle> searchByName(String name);
    public Vehicle searchById(String id);
    public void showAll();
    public void showDescPrice();
    
    
}
