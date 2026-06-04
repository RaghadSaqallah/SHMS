/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Strategy;
import Builder.BookingRoom;

public class BillingContext {

    private BillingStrategy strategy;

    public BillingContext(BillingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(BillingStrategy strategy) {
        this.strategy = strategy;
        System.out.println("  >> Billing strategy changed to: " + strategy.getStrategyName());
    }

    public double calculateBill(BookingRoom booking, int nights) {
        System.out.println("\n========== BILLING ==========");
        System.out.println("Strategy : " + strategy.getStrategyName());
        System.out.println("Guest    : " + booking.getFullName());
        System.out.println("Room     : " + booking.getRoom().getDetails());
        System.out.println("Nights   : " + nights);
        System.out.println("-----------------------------");

        double total = strategy.calculateTotal(booking.getRoom(), nights);

        System.out.println("-----------------------------");
        System.out.println("TOTAL    : $" + String.format("%.2f", total));
        System.out.println("=============================\n");

        return total;
    }
}