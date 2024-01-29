package hotel_manegement;

public class Hotel implements Comparable<Hotel> {

    private String Hotel_Id;
    private String Hotel_Name;
    private int Hotel_Room_Available;
    private String Hotel_Address;
    private String Hotel_Phone;
    private float Hotel_Rating;

    public Hotel(String Hotel_Id, String Hotel_Name, int Hotel_Room_Available, String Hotel_Address, String Hotel_Phone, float Hotel_Rating) {
        this.Hotel_Id = Hotel_Id;
        this.Hotel_Name = Hotel_Name;
        this.Hotel_Room_Available = Hotel_Room_Available;
        this.Hotel_Address = Hotel_Address;
        this.Hotel_Phone = Hotel_Phone;
        this.Hotel_Rating = Hotel_Rating;
    }

    

    public String getHotel_Id() {
        return Hotel_Id;
    }

    public void setHotel_Id(String Hotel_Id) {
        this.Hotel_Id = Hotel_Id;
    }

    public String getHotel_Name() {
        return Hotel_Name;
    }

    public void setHotel_Name(String Hotel_Name) {
        this.Hotel_Name = Hotel_Name;
    }

    public int getHotel_Room_Availabel() {
        return Hotel_Room_Available;
    }

    public void setHotel_Room_Available(int Hotel_Room_Available) {
        this.Hotel_Room_Available = Hotel_Room_Available;
    }

    public String getHotel_Address() {
        return Hotel_Address;
    }

    public void setHotel_Address(String Hotel_Address) {
        this.Hotel_Address = Hotel_Address;
    }

    public String getHotel_Phone() {
        return Hotel_Phone;
    }

    public void setHotel_Phone(String Hotel_Phone) {
        this.Hotel_Phone = Hotel_Phone;
    }

    public float getHotel_Rating() {
        return Hotel_Rating;
    }

    public void setHotel_Rating(float Hotel_Rating) {
        this.Hotel_Rating = Hotel_Rating;
    }

//    @Override
//    public String toString() {
//        return "|ID: " + Hotel_Id + "|, |Name: " + Hotel_Name + "|, |Room Available: " + Hotel_Room_Available + "|, |Address: " + Hotel_Address + "|, |Phone: + Hotel_Phone + "|, |Rating: " + Hotel_Rating + "|";
//    }
    @Override
    public String toString() {        
        return String.format("|%-10s|%-12s|%-22d|%-65s|%16s|%9.2f stars|\n", Hotel_Id, Hotel_Name, Hotel_Room_Available, Hotel_Address, Hotel_Phone, Hotel_Rating);
    }

    public int compareTo(Hotel t) {
        int check = this.getHotel_Name().compareTo(t.getHotel_Name());

        if (check != 0) {
            return check;
        } else {
            return this.getHotel_Id().compareTo(t.getHotel_Id());
        }
    }
}
