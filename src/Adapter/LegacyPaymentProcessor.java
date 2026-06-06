/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Adapter;

public class LegacyPaymentProcessor {

    public void makePayment(String clientName, double amount) {
        System.out.println("  [Legacy System] Processing payment...");
        System.out.println("  [Legacy System] Client : " + clientName);
        System.out.println("  [Legacy System] Amount : $" + String.format("%.2f", amount));
        System.out.println("  [Legacy System] Payment approved.");
    }
}