
package util;

import java.util.Scanner;

public class GetInput {
     public static String getString(String input) {
        boolean check = true;
        String result = "";
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(input);
            result = sc.nextLine();
            if (result.isEmpty()) {
                System.out.println("Invalid input!");
            } else {
                check = false;
            }
        } while (check);
        return result;
    }

    public static int getInt(String input, int min, int max) {
        boolean check = true;
        int number = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(input + "[" + min + ", " + max + "]: ");
                number = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        } while (check || number > max || number < min);
        return number;
    }

    public static double getDouble(String input, double min, double max) {
        boolean check = true;
        double number = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(input + "[" + min + ", " + max + "]: ");
                number = Double.parseDouble(sc.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        } while (check || number > max || number < min);
        return number;
    }
}
