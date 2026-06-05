
import Builder.BookingRoom;
import FactoryMethod.*;
import Observer.EventManager;
import Observer.Events.BookingConfirmedEvent;
import Observer.Guest;
import Observer.Manager;
import Observer.Staff;
import Singleton.Config;
import Strategy.*;
import TemplateMethod.*;

public class NewMain {

    public static void main(String[] args) {

        Config config = Config.getInstance();
        System.out.println("=== " + config.getHotelName() + " ===");
        System.out.println("Currency : " + config.getCurrency());
        System.out.println("Tax Rate : " + (config.getTaxRate() * 100) + "%");

        EventManager eventManager = new EventManager();
        eventManager.subscribe(new Staff("Mohammed"));
        eventManager.subscribe(new Manager("Ali Ahmed"));

        System.out.println("\n--- Room Creation ---");
        RoomFactory factory = new DeluxeRoomFactory();
        Room room = factory.createRoom();
        room.displayInfo();

        System.out.println("\n--- Booking ---");
        BookingRoom booking = new BookingRoom.Builder(room, "Sara Ahmed", "6-10-2026", "6-15-2026")
                .setBreakfast(true)
                .setLunch(false)
                .setDinner(true)
                .setDessert(true)
                .build();
        booking.printBookingInfo();
        eventManager.subscribe(new Guest(booking.getFullName()));
        eventManager.publish(new BookingConfirmedEvent(), booking.getFullName());

        HotelWorkflow checkIn = new CheckInWorkflow(eventManager);
        checkIn.executeWorkflow(booking);

        BillingContext billing = new BillingContext(new MemberDiscountStrategy());

        HotelWorkflow checkOut = new CheckOutWorkflow(billing, 5, eventManager);
        checkOut.executeWorkflow(booking);

        System.out.println("\n System completed successfully.");

    }
}
