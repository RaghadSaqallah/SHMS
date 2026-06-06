
import Builder.BookingRoom;
import FactoryMethod.*;
import Observer.EventManager;
import Observer.Events.BookingEvent;
import Observer.GuestObserver;
import Observer.ManagerObserver;
import Observer.StaffObserver;
import Singleton.Config;
import Strategy.*;
import TemplateMethod.*;

public class NewMain {

    public static void main(String[] args) {

        Config config = Config.getInstance();
        System.out.println("=== " + config.getHotelName() + " ===");
        System.out.println("Currency : " + config.getCurrency());
        System.out.println("Tax Rate : " + (config.getTaxRate() * 100) + "%");
        System.out.println("Check-In from  : " + config.getCheckInHour()  + ":00 PM");
        System.out.println("Check-Out by   : " + config.getCheckOutHour() + ":00 AM");

        EventManager eventManager = new EventManager();
        eventManager.subscribe(new StaffObserver());
        eventManager.subscribe(new ManagerObserver());

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
        eventManager.subscribe(new GuestObserver());
        eventManager.publish(new BookingEvent(), booking.getFullName());

        HotelWorkflow checkIn = new CheckInWorkflow(eventManager);
        checkIn.executeWorkflow(booking);

        BillingContext billing = new BillingContext(new MemberDiscountStrategy());
//          بداخله: Strategy (حساب الفاتورة) +
//                  Adapter (دفع عبر Legacy System) +
//                  PaymentEvent + CheckOutEvent
        HotelWorkflow checkOut = new CheckOutWorkflow(billing, 5, eventManager);
        checkOut.executeWorkflow(booking);

        System.out.println("\n System completed successfully.");

    }
}
