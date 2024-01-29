package my_utils;

import hotel_manegement.Hotel;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Utils {

    static Scanner sc = new Scanner(System.in);

    public static String getString(String msg, boolean canNull) {
        String inputdata = "";
        boolean valid = false;

        while (!valid) {
            System.out.println(msg);
            inputdata = sc.nextLine();

            if (canNull) {
                if (inputdata.isEmpty()) {
                    return null;
                } else {
                    valid = true;
                }
            } else {
                if (inputdata.isEmpty()) {
                    System.out.println("Input cannot be null or empty.");
                } else {
                    valid = true;
                }
            }
        }

        return inputdata;
    }

    public static String getString(String welcome, String msg) {
        boolean check = true;
        String result = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(welcome);
            result = sc.nextLine();
            if (result.isEmpty()) {
                System.out.println(msg);
            } else {
                check = false;
            }
        } while (check);
        return result;
    }

    public static float getNumFloat(String welcome) {
        String num;
        boolean check = true;
        float result = 0;
        do {
            try {
                System.out.print(welcome);
                Scanner sc = new Scanner(System.in);
                num = sc.nextLine();
                if ("".equals(num)) {
                    return result;
                } else {
                    return result = Float.parseFloat(num);
                }

            } catch (Exception e) {
                System.out.println("Input number!!!");
            }

        } while (check);
        return result;

    }

    public static int getNumInt(String welcome) {
        String num;
        boolean check = true;
        int result = 0;
        do {
            try {
                System.out.print(welcome);
                Scanner sc = new Scanner(System.in);
                num = sc.nextLine();
                if ("".equals(num)) {
                    return result;
                } else {
                    return result = Integer.parseInt(num);
                }

            } catch (Exception e) {
                System.out.println("Input number!!!");
            }

        } while (check);
        return result;

    }

    public static int getInt(String welcome, int min) {
        boolean check = true;
        int number = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {

                System.out.print(welcome);
                number = Integer.parseInt(sc.nextLine());
                if (number < min) {
                    System.out.println("Number must be large than " + min);
                } else {
                    check = false;
                }

            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check || number < min);
        return number;
    }

    public static String getStringCanNull(String welcome) {
        String result = "";
        Scanner sc = new Scanner(System.in);
        System.out.print(welcome);
        result = sc.nextLine();
        return result;
    }

    public static String getStringreg(String welcome, String pattern, String msg, String msgreg) {
        boolean check = true;
        String result = "";
        Scanner sc = new Scanner(System.in);
        do {

            System.out.print(welcome);
            result = sc.nextLine();
            if (result.isEmpty()) {
                System.out.println(msg);
            } else if (!result.matches(pattern)) {
                System.out.println(msgreg);
            } else {
                check = false;
            }
        } while (check);
        return result.toUpperCase();
    }

    public static int getSearch(String welcome, int min, int max) {
        boolean check = true;
        int number = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {

                System.out.print(welcome);
                number = Integer.parseInt(sc.nextLine());
                if (number < min || number > max) {
                    System.out.println("Choose 1 or 2");
                } else {
                    check = false;
                }

            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check || number < min);
        return number;
    }

    public static float getFloat(String welcome, int min, int max) {
        boolean check = true;
        float number = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {

                System.out.print(welcome);
                number = Float.parseFloat(sc.nextLine());
                if (number < min) {
                    System.out.println("Number must be large than " + min);
                } else if (number > max) {
                    System.out.println("Number must be least than " + max);
                } else {
                    check = false;
                }

            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check || number < min);
        return number;
    }

    public static String checkPhone(String msg, Hotel hotel) {
        Scanner sc = new Scanner(System.in);
        String phone = "";
        System.out.print(msg);
        Pattern pattern = Pattern.compile("\\d{10,11}");
        do {
            phone = sc.nextLine();
            if (phone.trim().isEmpty()) {
                return hotel.getHotel_Phone();
            } else if (!pattern.matcher(phone).matches()) {
                System.out.println("Enter phone with 10-11 numbers!!");
                System.out.print(msg);
            } else {
                return phone;
            }
        } while (true);
    }

}
