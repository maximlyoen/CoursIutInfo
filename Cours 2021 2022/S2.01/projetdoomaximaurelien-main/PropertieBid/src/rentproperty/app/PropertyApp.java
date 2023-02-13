/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentproperty.app;

import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Scanner;
import rentproperty.loans.LoansAccess;
import rentproperty.members.MemberAccess;
import rentproperty.property.PropertyAccess;

/**
 *
 * @author mlevecq
 */
public class PropertyApp {
    private LoansAccess lAccess; 
    private MemberAccess mAccess; 
    private PropertyAccess pAccess; 

    
    private Scanner scan;
    private ArrayList<String> menuItems;

    public PropertyApp() {
        lAccess = new LoansAccess();
        mAccess = new MemberAccess();
        pAccess = new PropertyAccess();
        
        scan = new Scanner(System.in);
        
        menuItems = new ArrayList<>();
        menuItems.add("Connect");
        menuItems.add("Create account");
        menuItems.add("Quit");
    }
    
    void run() {
        boolean quit = false;
        do {
            displayMenu();
            int choice = ARR_userNumericInput(0, menuItems.size() - 1, "Choose an action");
            quit = performAction(choice);
        } while (!quit);
    }

    private void displayMenu() {
        System.out.println("What do you want to do?");
        displayList(menuItems);
    }
    
    private void displayList(ArrayList<String> list) {
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); ++i) {
                System.out.println("" + i + "." + list.get(i));
            }
        } else {
            System.out.println("Giving up: no matches.");
        }
    }

    private int ARR_userNumericInput(int min, int max, String prompt) {
        int input = -1;
        do {
            System.out.format("%s.\nYour choice? [%d - %d]", prompt, min, max);
            System.out.println();
            input = scan.nextInt();
        } while (min > input || max < input);
        return input;
    }

    private String ARR_userStringInput(String prompt) {
        String input;
        do {
            System.out.format("Please enter %s:", prompt);
            System.out.println();
            input = scan.next();
        } while (input.length() < 1);
        return input;
    }
    
    private boolean performAction(int choice) {
        boolean res = false;
        switch (choice)  {
            case 0:
                System.out.println("Connection to your accout");
                res = true;
                break;
            case 1:
                System.out.println("Creation new account");
                res = true;
                break;
            case 2:
                System.out.println("QUIT");
                exit(0);
                res = true;
        }
        return res;
    }
    
    
}
