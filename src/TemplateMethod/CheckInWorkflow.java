/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TemplateMethod;
import Builder.BookingRoom;
import Observer.EventManager;
import Observer.Events.CheckInEvent;
import Singleton.Config;

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
        System.out.println("[Step 2] Preparing room...");
        System.out.println("  Room is being cleaned.");
        System.out.println("  Check-in from: " + Config.getInstance().getCheckInHour() + ":00 PM");
    }

    @Override
    protected void performMainAction(BookingRoom booking) {
        System.out.println("[Step 3] Performing Check-In...");
        System.out.println("  Welcome, " + booking.getFullName() + "!");
        System.out.println("  Room: " + booking.getRoom().getDetails());
        System.out.println("  Key card issued.");
        // observer
        eventManager.publish(new CheckInEvent(), booking.getFullName());  // observer اشعار  بانه تمت عملة التشيك ان
    }

    @Override
    protected void logToSystem(BookingRoom booking) {
        System.out.println("[Step 6] Logging check-in...");
        System.out.println("  Record saved for: " + booking.getFullName());
        System.out.println("  Arrival: " + booking.getArrivalDate());
    }
}