
package util;

public class Verify {
     public static boolean confirmYesNo(String input) {
        boolean result = false;
        boolean flag;
        do {
            String confirm = GetInput.getString(input);
            if ("Y".equalsIgnoreCase(confirm)) {
                result = true;
                flag = false;
            } else if ("N".equalsIgnoreCase(confirm)) {
                result = false;
                flag = false;
            } else {
                flag = true;
            }

        } while (flag);

        return result;
    }
    
}
