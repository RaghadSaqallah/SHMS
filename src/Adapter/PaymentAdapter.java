/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapter;

public class PaymentAdapter implements PaymentProcessor {

    private LegacyPaymentProcessor legacyProcessor;

    public PaymentAdapter() {
        this.legacyProcessor = new LegacyPaymentProcessor();
    }

    @Override
    public void processPayment(String guestName, double amount) {
        legacyProcessor.makePayment(guestName, amount);
    }
}