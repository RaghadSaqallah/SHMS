/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Strategy;
import FactoryMethod.Room;

public class MemberDiscountStrategy implements BillingStrategy {

    private static final double DISCOUNT_RATE = 0.20;

    @Override
    public double calculateTotal(Room room, int nights) {
        double originalPrice = room.getPrice() * nights;
        double discount = originalPrice * DISCOUNT_RATE;
        double finalPrice = originalPrice - discount;

        System.out.println("  [Member Discount] Original Price : $" + String.format("%.2f", originalPrice));
        System.out.println("  [Member Discount] Discount (20%) : -$" + String.format("%.2f", discount));

        return finalPrice;
    }

    @Override
    public String getStrategyName() {
        return "Member Discount (20% OFF)";
    }
}