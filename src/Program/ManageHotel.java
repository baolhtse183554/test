package Program;

import hotel_manegement.HandleHotel;
import hotel_manegement.Menu;
import java.util.Scanner;

public class ManageHotel {

    public static void main(String[] args) {
        String filename = "hotel.dat.txt";
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        menu.add("Adding new Hotel");
        menu.add("Checking exits Hotel");
        menu.add("Updating Hotel information");
        menu.add("Deleting Hotel");
        menu.add("Searching Hotel");
        menu.add("Displaying a hotel list");
        menu.add("Save to file");
        menu.add("Quit");
        int userChoice;
        boolean check = false;
        HandleHotel hotel = new HandleHotel();
        hotel.addFromFile(filename);
        do {
            System.out.println("\nHOTEL MANAGER");
            System.out.println("Your choice :");
            userChoice = menu.getUserChoice();
            switch (userChoice) {
                case 1:
                    hotel.addNewHotel();
                    check = true;
                    break;
                case 2:
                    hotel.checkExistHotel();
                    check = true;
                    break;
                case 3:
                    hotel.updateInfor();
                    check = true;
                    break;
                case 4:
                    hotel.delete();
                    check = true;
                    break;
                case 5:
                    hotel.searchHotel();
                    check = true;
                    break;
                case 6:
                    hotel.printList();
                    check = true;
                    break;
                case 7:
                    hotel.saveToFile(filename);
                    check = true;
                    break;
//                    if (check) {
//                        System.out.print("Save Y/N :");
//                        String respone = sc.nextLine().toUpperCase();
//                        if (respone.startsWith("Y")) {
//                            hotel.saveToFile(filename);
//                        }
//                        break;
//                    }
                default:
                    System.out.println("Good bai!!");
                    check = false;
                    break;
            }
        } while (userChoice > 0 && userChoice < 8);
    }
}
