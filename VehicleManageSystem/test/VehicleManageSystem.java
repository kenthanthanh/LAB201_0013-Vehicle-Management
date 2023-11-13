
import controller.VehicleManager;
import view.Menu;

public class VehicleManageSystem {

    public static void main(String[] args) {

        Menu mainMenu = new Menu();
        mainMenu.addItem("1. Load data from file");
        mainMenu.addItem("2. Add new vehicle");
        mainMenu.addItem("3. Update vehicle by ID");
        mainMenu.addItem("4. Delete vehicle by ID");
        mainMenu.addItem("5. Search vehicle");
        mainMenu.addItem("6. Show vehicle list");
        mainMenu.addItem("7. Store data to file");
        mainMenu.addItem("8. Quit");

        int choice;
        boolean confirm = false;
        VehicleManager vehicles = new VehicleManager();
        do {

            mainMenu.showMenu();
            choice = mainMenu.getChoice();
            switch (choice) {
                case 1 -> vehicles.loadData();
                case 2 -> vehicles.add();
                case 3 -> vehicles.update();

                case 4 -> vehicles.delete();

                case 5 -> vehicles.search();
                case 6 -> vehicles.show();

                case 7 -> vehicles.storeData();
                case 8 -> confirm = mainMenu.confirm("Do you want to quit?(Y/N): ");
                default -> {
                }
            }
        } while (!confirm);
    }

}
