package TemplateMethod;

import Builder.BookingRoom;
import Observer.EventManager;

/**
 * HotelWorkflow - Template Method Pattern (Abstract Class)
 *
 * @author
 */
public abstract class HotelWorkflow {

    protected EventManager eventManager;

    public HotelWorkflow(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    public final void executeWorkflow(BookingRoom booking) {
        System.out.println("Starting: " + getWorkflowName());

        validateBooking(booking);
        prepareProcess(booking);
        performMainAction(booking);
        processServices(booking);
        notifyGuest(booking);
        logToSystem(booking);
        System.out.println("\nWorkflow [" + getWorkflowName() + "] completed successfully.\n");
    }

    protected abstract void notifyGuest(BookingRoom booking);

    private void validateBooking(BookingRoom booking) {
        System.out.println("\n[Step 1] Validating booking...");
        if (booking == null) {
            throw new IllegalArgumentException("Booking cannot be null!");
        }
        System.out.println("Guest     : " + booking.getFullName());
        System.out.println("Room      : " + booking.getRoom().getDetails());
        System.out.println("Arrival   : " + booking.getArrivalDate());
        System.out.println("Departure : " + booking.getDepartureDate());
        System.out.println("Booking validated successfully.");
    }

    private void processServices(BookingRoom booking) {
        System.out.println("\n[Step 4] Processing requested services...");
        if (booking.isBreakfast()) {
            System.out.println("Breakfast service added.");
        }
        if (booking.isLunch()) {
            System.out.println("Lunch service added.");
        }
        if (booking.isDinner()) {
            System.out.println("Dinner service added.");
        }
        if (booking.isDessert()) {
            System.out.println("Dessert service added.");
        }

        if (!booking.isBreakfast() && !booking.isLunch()
                && !booking.isDinner() && !booking.isDessert()) {
            System.out.println("No additional services requested.");
        }
    }

    protected abstract String getWorkflowName();

    protected abstract void prepareProcess(BookingRoom booking);

    protected abstract void performMainAction(BookingRoom booking);

    protected abstract void logToSystem(BookingRoom booking);
}
