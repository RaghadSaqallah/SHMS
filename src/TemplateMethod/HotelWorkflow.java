/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TemplateMethod;
import Builder.BookingRoom;
import Singleton.Config;

public abstract class HotelWorkflow {

    public final void executeWorkflow(BookingRoom booking) {
        System.out.println("\n=== Starting: " + getWorkflowName() + " ===");

        validateBooking(booking);  
        prepareProcess(booking);    
        performMainAction(booking); 
        processServices(booking);  
        notifyGuest(booking);       
        logToSystem(booking);       

        System.out.println("=== " + getWorkflowName() + " Completed ===\n");
    }

    // خطوات ثابتة
    private void validateBooking(BookingRoom booking) {
        System.out.println("[Step 1] Validating booking...");
        System.out.println("  Guest: " + booking.getFullName());
        System.out.println("  Room : " + booking.getRoom().getDetails());
    }

    private void processServices(BookingRoom booking) {
        System.out.println("[Step 4] Processing services...");
        if (booking.isBreakfast()) System.out.println("  Breakfast added.");
        if (booking.isLunch())     System.out.println("  Lunch added.");
        if (booking.isDinner())    System.out.println("  Dinner added.");
        if (booking.isDessert())   System.out.println("  Dessert added.");
    }

    private void notifyGuest(BookingRoom booking) {
        System.out.println("[Step 5] Notification sent to: " + booking.getFullName());
    }

    protected abstract String getWorkflowName();
    protected abstract void prepareProcess(BookingRoom booking);
    protected abstract void performMainAction(BookingRoom booking);
    protected abstract void logToSystem(BookingRoom booking);
}