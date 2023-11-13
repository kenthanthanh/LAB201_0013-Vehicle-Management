package view;

import java.util.ArrayList;
import util.GetInput;
import util.Verify;

public class Menu extends ArrayList<String> implements MenuInterface {

    public Menu() {
        super();
    }

    @Override
    public void showMenu() {
        for (String content : this) {
            System.out.println(content);
        }
    }

    @Override
    public boolean confirm(String content) {
        boolean result = false;
        result = Verify.confirmYesNo(content);
        return result;
    }

    @Override
    public void addItem(String item) {
        this.add(item);
    }

    @Override
    public int getChoice() {
        return GetInput.getInt("Input your choice: ", 1, this.size());
    }

}
