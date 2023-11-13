import java.util.Scanner;

public class VehicleManagementSystem extends AbstractMenu {
        Scanner input = new Scanner(System.in);

    @Override
    public void menu() {

        int choice;
        do {
            System.out.println("Vehicle Management System");
            System.out.println("------------------------------");
            System.out.println("1. Load data from file");
            System.out.println("2. Add new vehicle");
            System.out.println("3. Update vehicle by ID");
            System.out.println("4. Delete vehicle ID");
            System.out.println("5. Search vehicle");
            System.out.println("6. Show vehicle list");
            System.out.println("7. Store data to file");
            System.out.println("0. Quit!");

            System.out.println("------------------------------");
            System.out.print("Enter selection: ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1: {
                    // students.addStudent();
                    System.out.println("***Information of student has been added!");
                    break;
                }
                case 2: {
                    // this.menuSearch();
                    break;
                }

                case 3: {
                    System.out.println("List of all available student:");
                    // students.listStudents();
                    break;
                }
                case 4: {
                    // students.savingDataToFile();
                    break;
                }
                case 5: {
                    searchMenu();

                    // ;
                    break;
                }
                 case 6: {
                    showMenu();
                    // ;
                    break;
                }
                 case 7: {
                    
                    // ;
                    break;
                }
                case 0:
                    break;
                default:
                    System.out.println("***Your select is invalid! Let to try again!");
                    break;
            }

        } while (choice != 0);


    }
    @Override
    public void searchMenu() {
        int choose;
        do {
            System.out.println("Search vehicle");
            System.out.println("------------------------------");
            System.out.println("1. Search by name (descending)");
            System.out.println("2. Search by ID");
            System.out.println("0. Back the main menu!");
            System.out.println("------------------------------");
            System.out.print("Enter selection: ");
            choose = input.nextInt();
            input.nextLine();
            switch (choose) {
                case 1: {
                    // students.getStudentByID();
                    break;
                }
                case 2: {
                    // students.getStudentByLastName();
                    break;
                }
                case 0:
                    break;
                default:
                    System.out.println("***Your select is invalid! Let to try again!");
                    break;
            }

        } while (choose != 0);

    }

    @Override
    public void showMenu()
    {
  int choose;
        do {
            System.out.println("Show vehicle list");
            System.out.println("------------------------------");
            System.out.println("1. Show all");
            System.out.println("2. Show all (descending by price)");
            System.out.println("0. Back the main menu!");
            System.out.println("------------------------------");
            System.out.print("Enter selection: ");
            choose = input.nextInt();
            input.nextLine();
            switch (choose) {
                case 1: {
                    // students.getStudentByID();
                    break;
                }
                case 2: {
                    // students.getStudentByLastName();
                    break;
                }
                case 0:
                    break;
                default:
                    System.out.println("***Your select is invalid! Let to try again!");
                    break;
            }

        } while (choose != 0);

    }
    public static void main(String[] args) {
        VehicleManagementSystem vms = new VehicleManagementSystem();
        vms.menu();
    }
  
}
