/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Strategy;
import FactoryMethod.Room;

public class SeasonalPricingStrategy implements BillingStrategy {

    private static final double SEASONAL_MULTIPLIER = 1.30;

    @Override
    public double calculateTotal(Room room, int nights) {
        double originalPrice = room.getPrice() * nights;
        double surcharge = originalPrice * 0.30;
        double finalPrice = originalPrice * SEASONAL_MULTIPLIER;

        System.out.println("  [Seasonal Pricing] Original Price : $" + String.format("%.2f", originalPrice));
        System.out.println("  [Seasonal Pricing] Peak Surcharge : +$" + String.format("%.2f", surcharge));

        return finalPrice;
    }

    @Override
    public String getStrategyName() {
        return "Seasonal Pricing (Peak +30%)";
    }
}