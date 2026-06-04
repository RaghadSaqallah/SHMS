import Builder.BookingRoom;
import FactoryMethod.*;
import Singleton.Config;
import Strategy.*;
import TemplateMethod.*;

public class NewMain {

    public static void main(String[] args) {

       
        Config config = Config.getInstance();
        System.out.println("=== " + config.getHotelName() + " ===");
        System.out.println("Currency : " + config.getCurrency());
        System.out.println("Tax Rate : " + (config.getTaxRate() * 100) + "%");

      
        System.out.println("\n--- Room Creation (Factory Method) ---");
        RoomFactory factory = new DeluxeRoomFactory();
        Room room = factory.createRoom();
        room.displayInfo();

        System.out.println("\n--- Booking (Builder Pattern) ---");
        BookingRoom booking = new BookingRoom.Builder(room, "Sara Ahmed", "6-10-2026", "6-15-2026")
                .setBreakfast(true)
                .setLunch(false)
                .setDinner(true)
                .setDessert(true)
                .build();
        booking.printBookingInfo();

      
        HotelWorkflow checkIn = new CheckInWorkflow();
        checkIn.executeWorkflow(booking);

        
        BillingContext billing = new BillingContext(new MemberDiscountStrategy());

       
        HotelWorkflow checkOut = new CheckOutWorkflow(billing, 5);
        checkOut.executeWorkflow(booking);

        System.out.println("\n System completed successfully.");
        
    }
}
