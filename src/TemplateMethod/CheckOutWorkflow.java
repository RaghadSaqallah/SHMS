/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TemplateMethod;

import Builder.BookingRoom;
import Observer.EventManager;
import Observer.Events.CheckOutEvent;
import Singleton.Config;
import Strategy.BillingContext;

public class CheckOutWorkflow extends HotelWorkflow {

    private BillingContext billingContext;
    private int nights;
    
    public CheckOutWorkflow(BillingContext billingContext, int nights, EventManager eventManager) {
        super(eventManager);
        this.billingContext = billingContext;
        this.nights = nights;

    }

    @Override
    protected String getWorkflowName() {
        return "CHECK-OUT WORKFLOW";
    }

    @Override
    protected void prepareProcess(BookingRoom booking) {
        System.out.println("[Step 2] Preparing for guest departure...");
        System.out.println("  Room inspection done. No damages reported.");
        System.out.println("  Check-out by: " + Config.getInstance().getCheckOutHour() + ":00 AM");
    }

    @Override
    protected void performMainAction(BookingRoom booking) {
        System.out.println("[Step 3] Performing Check-Out...");

        // الفاتورة تتحسب هنا جوا الـ Workflow عن طريق الـ Strategy
        double bill = billingContext.calculateBill(booking, nights);

        System.out.println("  Goodbye, " + booking.getFullName() + "!");
        System.out.println("  Room key returned.");
        System.out.println("  Final Bill: $" + String.format("%.2f", bill));
        System.out.println("  Payment confirmed.");
        System.out.println("  Thank you for staying at " + Config.getInstance().getHotelName() + "!");
       
        //observer ارسال اشعارت ب event التشيك اوت
        eventManager.publish(new CheckOutEvent(), booking.getFullName());  // اشعار التشيك اوت 
    }

    @Override
    protected void logToSystem(BookingRoom booking) {
        System.out.println("[Step 6] Logging check-out to system...");
        System.out.println("  Departure date: " + booking.getDepartureDate());
        System.out.println("  Room [" + booking.getRoom().getDetails() + "] marked as AVAILABLE.");
        System.out.println("  Invoice archived.");
    }
}
