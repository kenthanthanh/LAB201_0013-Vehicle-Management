package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import view.Menu;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Car;
import model.Motorbike;
import model.Vehicle;
import util.GetInput;
import util.Verify;

public class VehicleManager extends ArrayList<Vehicle> implements ManagerInterface, Serializable {

    private ArrayList<Vehicle> vehicles;

    public VehicleManager(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public VehicleManager(ArrayList<Vehicle> vehicles, Collection<? extends Vehicle> c) {
        super(c);
        this.vehicles = vehicles;
    }

    public VehicleManager() {
        this.vehicles = new ArrayList<>();
    }

    @Override
    public void loadData() {
        FileReader reader = null;
        BufferedReader bfr = null;
        boolean flag = true;
        try {
            reader = new FileReader("data2.txt");
            bfr = new BufferedReader(reader);
            String line;
            while ((line = bfr.readLine()) != null) {
                String[] tokens = line.split(",");
                String type = tokens[0];
                Vehicle vehicle;
                switch (type) {
                    case "Car" ->
                        vehicle = new Car(tokens[1], tokens[2], tokens[3], Double.parseDouble(tokens[4]), tokens[5], tokens[6], Integer.parseInt(tokens[7]));

                    case "Motorbike" ->
                        vehicle = new Motorbike(tokens[1], tokens[2], tokens[3], Double.parseDouble(tokens[4]), tokens[5], Double.parseDouble(tokens[6]), Boolean.parseBoolean(tokens[7]));
                    default -> {
                        continue;
                    }
                }
                vehicles.add(vehicle);
//                System.out.println(vehicle.toString());

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(VehicleManager.class.getName()).log(Level.SEVERE, null, ex);
            flag = false;
        } catch (IOException ex) {
            flag = false;
            Logger.getLogger(VehicleManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(VehicleManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                bfr.close();
            } catch (IOException ex) {
                Logger.getLogger(VehicleManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (flag) {
                System.out.println("File read successfully.");
            } else {
                System.out.println("File read failed.");
            }
        }
    }

    @Override
    public void storeData() {
        FileWriter writer = null;
        BufferedWriter bfw = null;
        boolean flag = true;
        try {
            writer = new FileWriter("data2.txt");
            bfw = new BufferedWriter(writer);
            for (Vehicle vehicle : vehicles) {
                String line = vehicle.getFileLineFormat() + "\n";
                bfw.write(line);

            }
            bfw.flush();
        } catch (IOException ex) {
            flag = false;
            Logger.getLogger(VehicleManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(VehicleManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                bfw.close();
            } catch (IOException ex) {
                Logger.getLogger(VehicleManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (flag) {
                System.out.println("File store successfully.");
            } else {
                System.out.println("File store failed.");
            }

        }

//        Ghi đối tượng thành chuỗi nhị phân sử dụng ObjectOutputStream
//        FileOutputStream fos = null;
//        FileOutputStream fos = null;
//            ObjectOutputStream oos = null;
//        try {
//            fos= new FileOutputStream("data1.txt");
//            oos = new ObjectOutputStream(fos);
//            for(Vehicle vehicle: vehicles){
//                oos.writeObject(vehicle);
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(VehicleManager.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(VehicleManager.class.getName()).log(Level.SEVERE, null, ex);
//        }finally{
//            if(fos != null)
//                try {
//                    fos.close();
//            } catch (IOException ex) {
//                Logger.getLogger(VehicleManager.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            if(oos != null)
//                try {
//                    oos.close();
//            } catch (IOException ex) {
//                Logger.getLogger(VehicleManager.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//        }
    }

    @Override
    public void add() {
        Menu addMenu = new Menu();
        addMenu.addItem("1. Add car");
        addMenu.addItem("2. Add motorbike");
        String id;
        int choice;
        boolean status;
        boolean exit = false;
        do {     
            id = GetInput.getString("Enter vehicle's id: ");
            if (searchById(id) != null) {
                System.out.println("Vehicle's id was exits!");
                status = false;
            } else {
                status = true;
            }
            if (status) {
                String name = GetInput.getString("Enter name: ");
                String color = GetInput.getString("Enter color: ");
                double price = GetInput.getDouble("Enter price: ", 0, 9999);
                String brand = GetInput.getString("Enter brand: ");

                System.out.println("Choice type of vehicle: ");
                addMenu.showMenu();
                choice = addMenu.getChoice();
                switch (choice) {
                    case 1 -> {
                        String type = GetInput.getString("Enter type: ");
                        int yearOfManufacture = GetInput.getInt("Enter year of manufacture: ", 0, 2023);

                        status = vehicles.add(new Car(id, name, color, price, brand, type, yearOfManufacture));
                    }
                    case 2 -> {
                        double speed = GetInput.getDouble("Enter speed: ", 0, 9999);
                        boolean requiceLicense = Verify.confirmYesNo("License Requirement (Y/N): ");
                        status = vehicles.add(new Motorbike(id, name, color, price, brand, speed, requiceLicense));
                    }

                }

                if (status) {
                    System.out.println("Add successfully!");
                }
                exit = Verify.confirmYesNo("Do you want to continue adding (Y/N)?: ");
            }
        } while (exit);
    }

    @Override
    public void update() {
        boolean check;
        String id = GetInput.getString("Enter vehicle's ID to update: ");
        Vehicle vehicle = this.searchById(id);
        if (vehicle == null) {
            System.out.println("Vehicle doesn't exist!");
            check = false;
        } else {
            String name = GetInput.getString("Enter new name: ");
            vehicle.setName(name);
            String color = GetInput.getString("Enter new color: ");
            vehicle.setColor(color);
            double price = GetInput.getDouble("Enter new price: ", 0, 9999);
            vehicle.setPrice(price);
            String brand = GetInput.getString("Enter new brand: ");
            vehicle.setBrand(brand);
            if (vehicle instanceof Car car) {
                String type = GetInput.getString("Enter new type: ");
                car.setType(type);
                int yearOfManufacture = GetInput.getInt("Enter new year of manufacture: ", 0, 2023);
                car.setYearOfManufacture(yearOfManufacture);
                check = true;

            } else {
                double speed = GetInput.getDouble("Enter new speed: ", 0, 499);
                ((Motorbike) vehicle).setSpeed(speed);
                boolean requireLicense = Verify.confirmYesNo("License Requirement(Y/N): ");
                ((Motorbike) vehicle).setRequiresLicense(requireLicense);
                check = true;
            }

        }
        if (check) {
            System.out.println("Data after updated!");
        }
        System.out.println(vehicle.toString());

    }

    @Override
    public void delete() {
        boolean check;
        String id = GetInput.getString("Enter vehicle's ID to delete: ");
        Vehicle vehicle = searchById(id);
        if (vehicle == null) {
            System.out.println("Vehicle does not exist!");
            check = false;
        } else {
            check = Verify.confirmYesNo("Are you sure (Y/N)?: ");
        }
        if (check == true) {
            this.remove(vehicle);
            System.out.println("Delete successfully!");
        }
    }

    @Override
    public ArrayList<Vehicle> searchByName(String name
    ) {

        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getName().equals(name)) {
                result.add(vehicle);
            }
        }
        return result.isEmpty() ? null : result;
    }

    @Override
    public Vehicle searchById(String id
    ) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId().equals(id)) {
                return vehicle;
            }
        }
        return null;

    }

    @Override
    public void search() {
        Menu searchMenu = new Menu();
        searchMenu.addItem("1. Search by name");
        searchMenu.addItem("2. Search by id");
        searchMenu.showMenu();
        int choice = searchMenu.getChoice();
        switch (choice) {
            case 1 -> {
                String name = GetInput.getString("Enter name to search: ");
                ArrayList<Vehicle> result = searchByName(name);
                if (result != null) {
                    for (Vehicle vehicle : result) {
                        System.out.println(vehicle.toString());
                    }

                } else {
                    System.out.println("Not found!");
                }
            }
            case 2 -> {
                String id = GetInput.getString("Enter id to search: ");
                Vehicle result = searchById(id);
                if (result != null) {
                    System.out.println(result.toString());

                } else {
                    System.out.println("Not found!");
                }
            }
        }
    }

    @Override
    public void showAll() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles to show!");
            return;
        }
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
    }

    @Override
    public void showDescPrice() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles to show!");
            return;
        }
        Collections.sort(vehicles, (Vehicle o1, Vehicle o2) -> Double.compare(o1.getPrice(), o2.getPrice()));
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
            if (vehicle instanceof Motorbike motorbike) {
                motorbike.makeSound();
            }
        }
    }

    @Override
    public void show() {
        Menu menuShow = new Menu();
        menuShow.addItem("1. Show all");
        menuShow.addItem("2. Show all( descending by price)");
        menuShow.showMenu();
        int choice = menuShow.getChoice();
        switch (choice) {
            case 1 ->
                showAll();
            case 2 ->
                showDescPrice();
        }
    }

}
