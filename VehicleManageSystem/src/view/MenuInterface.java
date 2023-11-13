/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package view;

/**
 *
 * @author kei ti ti
 */
public interface MenuInterface {
    public void addItem(String item);
    public void showMenu();
    public int getChoice();
    public boolean confirm(String content);
}
