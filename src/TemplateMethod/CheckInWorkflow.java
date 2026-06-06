

package TemplateMethod;

import Builder.BookingRoom;
import Observer.EventManager;
import Observer.Events.CheckInEvent; 
import Singleton.Config;
/** 
 * @author
 */
public class CheckInWorkflow extends HotelWorkflow {
    
    public CheckInWorkflow(EventManager eventManager) {
        super(eventManager);
    }

    @Override
    protected String getWorkflowName() {
        return "CHECK-IN WORKFLOW";
    }
    @Override
    protected void prepareProcess(BookingRoom booking) {
        System.out.println("\n[Step 2] Preparing room for guest arrival...");
        System.out.println("Room [" + booking.getRoom().getDetails() + "] is being cleaned.");
        System.out.println("Amenities are stocked.");
        System.out.println("Room key card is being prepared.");

        // استخدام الـ Config Singleton للتحقق من وقت الـ check-in
        Config config = Config.getInstance();
        System.out.println("Check-in available from: "
                + config.getCheckInHour() + ":00 PM");
    }

    @Override
    protected void performMainAction(BookingRoom booking) {
        System.out.println("\n[Step 3] Performing Check-In...");
        System.out.println("Welcome, " + booking.getFullName() + "!");
        System.out.println("Room assigned: " + booking.getRoom().getDetails());
        System.out.println("Room price per night: $"
                + String.format("%.2f", booking.getRoom().getPrice()));
        System.out.println(" Key card issued to guest.");
        System.out.println("Check-in completed at hotel: "
                + Config.getInstance().getHotelName());
    }
     @Override
    protected void notifyGuest(BookingRoom booking) {
        // نشر حدث "Check-In" لجميع المراقبين 
        eventManager.publish(new CheckInEvent(), booking.getFullName());
    }
    @Override
    protected void logToSystem(BookingRoom booking) {
        System.out.println("\n[Step 6] Logging check-in to system...");
        System.out.println("Check-in record created for: " + booking.getFullName());
        System.out.println("Arrival date logged: " + booking.getArrivalDate());
        System.out.println("System record saved.");
    }
}
