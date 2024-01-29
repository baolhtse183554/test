
package hotel_manegement;


import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends ArrayList<String> {

    public Menu() {
        super();
    }

    public int getUserChoice() {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        for (int i = 0; i < this.size(); i++) {
            System.out.println(i + 1 + "." + this.get(i));
        }
        System.out.println("-------------------------------");
        do {
            System.out.print("Enter from 1 to 8 :");
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice < 1 || choice > 8) {
                    System.out.println("Choice from 1 to 7");
                }
            } catch (Exception e) {
                System.out.println("Wrong format, please try again :");
            }
        } while (choice < 1 || choice > 8);
        return choice;
    }
}

