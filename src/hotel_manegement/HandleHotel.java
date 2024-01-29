package hotel_manegement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import my_utils.Utils;

public class HandleHotel {
    
    static List<Hotel> hotelList = new ArrayList();
    private Hotel hotel;
    
    public void addFromFile(String fName) {
        try {
            File file = new File(fName);
            if (!file.exists()) {
                return;
            }
            FileReader fr = new FileReader(file);
            BufferedReader bf = new BufferedReader(fr);
            String infor;
            while ((infor = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(infor, ":");
                String id = stk.nextToken();
                String name = stk.nextToken();
                int roomAvailable = Integer.parseInt(stk.nextToken());
                String address = stk.nextToken();
                String phone = stk.nextToken();
                float rating = Float.parseFloat(stk.nextToken());
                Hotel hotel = new Hotel(id, name, roomAvailable, address, phone, rating);
                hotelList.add(hotel);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void saveToFile(String fName) {
        if (hotelList.isEmpty()) {
            System.out.println("The list is empty!");
            return;
        }
        try {
            File file = new File(fName);
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);
            for (Hotel x : hotelList) {
                pw.println(x.getHotel_Id() + ":" + x.getHotel_Name() + ":" + x.getHotel_Room_Availabel() + ":" + x.getHotel_Address() + ":" + x.getHotel_Phone() + ":" + x.getHotel_Rating());
            }
            pw.close();
            fw.close();
            System.out.println("Save successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public void addNewHotel() {
        String id = inputCode();
        String name = Utils.getString("Enter name: ", "Name not be null");
        int roomAvailable = Utils.getInt("Enter room: ", 1);
        String address = Utils.getString("Enter address: ", "Address not be null");
        String phone = Utils.getString("Enter phone: ", "Phone not be null");
        float rating = Utils.getFloat("Enter rating: ", 0, 6);
        Hotel hotel = new Hotel(id, name, roomAvailable, address, phone, rating);
        hotelList.add(hotel);
    }
    
    public void searchHotel() {
        System.out.println("What would you want to search \n1.By ID \n2.By Name \n3.By Phone(Last 3 digits)");
        int choice = 0;
        do {
            try {
                choice = Utils.getSearch("Enter your choice: ", 1, 3);
            } catch (Exception e) {
                System.out.println(e);
            }
            
        } while (choice < 1 || choice > 3);
        if (choice == 1) {
            
            String id = Utils.getString("Enter ID to search: ", "ID not be null");
            int check = findById(id);
            if (check == -1) {
                System.out.println("Not found this hotel");
            } else {
                System.out.println(hotelList.get(check));
            }
            
        }else if(choice == 2){
            String name = Utils.getString("Enter name to search: ","Name not be null!");
            int check = findByName(name);
            if(check == -1){
                System.out.println("Not found this hotel!");
            }else{
                for(int i = 0; i<hotelList.size(); i++){
                    if(hotelList.get(i).getHotel_Name().toUpperCase().startsWith(name.toUpperCase())){
                        System.out.println(hotelList.get(i));
                    }
                }
            }
        }else{
            String phone = Utils.getString("Enter last 3 digits phone number to search: ", "Phone not be null!");
            for(int i = 0; i<hotelList.size();i++){
                if(hotelList.get(i).getHotel_Phone().endsWith(phone)){
                    System.out.println(hotelList.get(i));
                }
            }
        }
    }
    public void updateHotel(){
        String id = Utils.getString("Enter ID to update: ", "ID not be null!");
        int check = findById(id);
        if(check == -1){
            System.out.println("Not found");
        }else{
            String name = Utils.getStringCanNull("Enter new name: ");
            if("".equals(name)){
                System.out.println(hotelList.get(check));
            }
            int roomAvailable = Utils.getNumInt("Enter new room: ");
            if(roomAvailable == 0){
                System.out.println(hotelList.get(check));
            }
            String address = Utils.getStringCanNull("Enter new address");
            if("".equals(address)){
                System.out.println(hotelList.get(check));
            }
            String phone = Utils.getStringCanNull("Enter new phone: ");
            if("".equals(phone)){
                System.out.println(hotelList.get(check));
            }
            float rating = Utils.getNumFloat("Enter new rating: ");
            if(rating == 0){
                System.out.println(hotelList.get(check));
            }
            hotelList.get(check).setHotel_Name(name);
            hotelList.get(check).setHotel_Room_Available(roomAvailable);
            hotelList.get(check).setHotel_Address(address);
            hotelList.get(check).setHotel_Phone(phone);
            hotelList.get(check).setHotel_Rating(rating);
            System.out.println(hotelList.get(check));
        }
    }
//    public void addFromFile(String fName) {
//        try {
//            File file = new File(fName);
//            if (!file.exists()) {
//                return;
//            }
//            FileReader fr = new FileReader(file);
//            BufferedReader bf = new BufferedReader(fr);
//            String infor;
//            while ((infor = bf.readLine()) != null) {
//                StringTokenizer stk = new StringTokenizer(infor, ":");
//                String id = stk.nextToken();
//                String name = stk.nextToken();
//                int roomAvailable = Integer.parseInt(stk.nextToken());
//                String address = stk.nextToken();
//                String phone = stk.nextToken();
//                float rating = Float.parseFloat(stk.nextToken());
//                Hotel hotel = new Hotel(id, name, roomAvailable, address, phone, rating);
//                hotelList.add(hotel);
//
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//
//    public void saveToFile(String fName) {
//        if (hotelList.isEmpty()) {
//            System.out.println("The List is empty!");
//            return;
//        }
//        try {
//            File file = new File(fName);
//            FileWriter fw = new FileWriter(file);
//            PrintWriter pw = new PrintWriter(fw);
//            for (Hotel x : hotelList) {
//                pw.println(x.getHotel_Id() + ":" + x.getHotel_Name() + ":" + x.getHotel_Room_Availabel() + ":" + x.getHotel_Address() + ":" + x.getHotel_Phone() + ":" + x.getHotel_Rating());
//            }
//            pw.close();
//            fw.close();
//            System.out.println("Save successfully");
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }

//    public void addNewHotel() {
//        System.out.println("====ADD NEW HOTEL====");
//        String id = inputCode();
//        String name = Utils.getString("Enter name: ", "Name not be null");
//        int roomAvailable = Utils.getInt("Enter room: ", 1);
//        String address = Utils.getString("Enter address: ", "Address not be null");
//        String phone = Utils.checkPhone("Enter phone: ", hotel);
//        float rating = Utils.getFloat("Enter rating: ", 1, 6);
//        Hotel hotel = new Hotel(id, name, roomAvailable, address, phone, rating);
//        hotelList.add(hotel);
//        System.out.println("Add Successfully!");
//
//    }
    private String inputCode() {
        String code = "";
        while (true) {
            int flag = 0; // set flag = 0 every loop
            code = Utils.getStringreg("Input code: ", "H\\d{2}$", "Code not be null", "Code must be in form <Hxx>");
            for (Hotel x : hotelList) {
                if (x.getHotel_Id().equals(code)) {
                    System.out.println("Each hotel has unique ID!");
                    flag = 1; // check if code exists flag = 1
                }
            }
            if (flag == 0) {
                return code;
            }
        }
    }
    
    public void printList() {
        if (hotelList.isEmpty()) {
            System.out.println("The list is empty!");
            return;
        }
        Collections.sort(hotelList);
        System.out.println("Hotel list: ");
        for (Hotel x : hotelList) {
            System.out.println(x);
        }
        
    }
    
//    public void searchHotel() {
//        int choice = 0;
//        System.out.println("What would you want to search: \n1.By ID \n2.By Name \n3.By Phone(Last 3 digits)");
//        do {
//            try {
//                choice = Utils.getSearch("Enter your choice: ", 1, 3);
//                
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//        } while (choice < 1 || choice > 3);
//        if (choice == 1) {
//            String infor = Utils.getString("Enter ID to search: ", "ID not be null");
//            int check = findById(infor);
//            if (check == -1) {
//                System.out.println("This hotel not found!");
//            } else {
//                System.out.println(hotelList.get(check));
//            }
//        } else if (choice == 2) {
//            String infor = Utils.getString("Enter name to search: ", "Name should not be null");
//            int check = findByName(infor);
//            if (check == -1) {
//                System.out.println("This hotel not found!");
//            } else {
//                for (int i = 0; i < hotelList.size(); i++) {
//                    if (hotelList.get(i).getHotel_Name().toUpperCase().equals(infor.toUpperCase())) {
//                        System.out.println(hotelList.get(i));
//                    }
//                }
//            }
//        } else {
//            String phone = Utils.getString("Enter the last three digits of the phone number to search: ", "Phone must not be null");
//            boolean found = false;
//            for (int i = 0; i < hotelList.size(); i++) {
//                if (hotelList.get(i).getHotel_Phone().endsWith(phone)) {
//                    System.out.println(hotelList.get(i));
//                    found = true;
//                }
//            }
//            if (!found) {
//                System.out.println("Not found!");
//            }
//        }
//    }
    
    public void updateInfor() {
        String infor = Utils.getString("Enter ID to update: ", "ID not be null");
        int check = findById(infor);
        if (check == -1) {
            System.out.println("Not found this hotel");
        } else {
            System.out.println("Update hotel: ");
            String name = Utils.getStringCanNull("Enter new name: ");
            if ("".equals(name)) {
                name = hotelList.get(check).getHotel_Name();
            }
            int roomAvailble = Utils.getNumInt("Enter new room: ");
            if (roomAvailble == 0) {
                roomAvailble = hotelList.get(check).getHotel_Room_Availabel();
            }
            String address = Utils.getStringCanNull("Enter new address: ");
            if ("".equals(address)) {
                address = hotelList.get(check).getHotel_Address();
            }
            String phone = Utils.checkPhone("Enter new phone: ", hotelList.get(check));
            if ("".equals(phone)) {
                phone = hotelList.get(check).getHotel_Phone();
            }
            float rating = Utils.getNumFloat("Enter new rating: ");
            if (rating == 0) {
                rating = hotelList.get(check).getHotel_Rating();
            }
            hotelList.get(check).setHotel_Name(name);
            hotelList.get(check).setHotel_Room_Available(roomAvailble);
            hotelList.get(check).setHotel_Address(address);
            hotelList.get(check).setHotel_Phone(phone);
            hotelList.get(check).setHotel_Rating(rating);
            System.out.println(hotelList.get(check));
            System.out.println("Update successfully!");
        }
    }
    
    public void delete() {
        String infor = Utils.getString("Enter hotel ID to delete: ", "ID not be null");
        int check = findById(infor);
        
        if (check == -1) {
            System.out.println("Not found this hotel!!");
        } else {
            System.out.println("Do you want to delete this hotel? (Y/N): ");
            String answer = Utils.getString("", "Please enter Y or N").toUpperCase();
            
            if (answer.startsWith("Y")) {
                hotelList.remove(check);
                System.out.println("Delete successfully!!");
            } else {
                System.out.println("Delete canceled.");
            }
        }
    }
    
    public void checkExistHotel() {
        String infor = Utils.getString("Enter hotel ID: ", "ID not be null");
        int check = findById(infor);
        if (check == -1 || check >= hotelList.size()) {
            System.out.println("No Hotel found");
        } else {
            System.out.println("Exists hotel");
            System.out.println(hotelList.get(check));
        }
        
    }
    
    private int findById(String infor) {
        for (int i = 0; i < hotelList.size(); i++) {
            if (hotelList.get(i).getHotel_Id().toUpperCase().equals(infor.toUpperCase())) {
                return i;
            }
        }
        return -1;
    }
    
    private int findByName(String infor) {
        for (int i = 0; i < hotelList.size(); i++) {
            if (hotelList.get(i).getHotel_Name().toUpperCase().equalsIgnoreCase(infor.toUpperCase()));
            return i;
        }
        return -1;
    }
    
}
