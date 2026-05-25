
import Builder.BookingRoom;
import FactoryMethod.DeluxeRoomFactory;
import FactoryMethod.Room;
import FactoryMethod.RoomFactory;
import Singleton.Config;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author AL
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RoomFactory f = new DeluxeRoomFactory();
        Room m = f.createRoom();
       
        BookingRoom b = new  BookingRoom.Builder(m, "Raghad Saqallah", "5-27-2026", "6-1-2026")
                .setBreakfast(false).setDessert(true).setDinner(true).setLunch(true).build();
        b.printBookingInfo();
        
     

    }

}
