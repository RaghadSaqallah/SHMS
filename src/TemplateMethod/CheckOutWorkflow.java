package TemplateMethod;
 
import Adapter.PaymentAdapter;
import Adapter.PaymentProcessor;
import Builder.BookingRoom;
import Observer.EventManager;
import Observer.Events.CheckOutEvent;
import Observer.Events.PaymentEvent;
import Singleton.Config;
import Strategy.BillingContext;
 
/**
 * CheckOutWorkflow - تنفيذ خطوات تسجيل الخروج
 * 
 * @author 
 */
public class CheckOutWorkflow extends HotelWorkflow {

    private BillingContext billingContext;
    private int nights;
     private PaymentProcessor paymentProcessor; // Adapter
   
     public CheckOutWorkflow(BillingContext billingContext, int nights, EventManager eventManager) {
        super(eventManager);
        this.billingContext = billingContext;
        this.nights = nights;
        this.paymentProcessor = new PaymentAdapter(); // تكامل مع النظام القديم

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
 // حساب الفاتورة (Strategy) + الدفع (Adapter) — كل شيء هنا مرة واحدة فقط
    @Override
    protected void performMainAction(BookingRoom booking) {
        System.out.println("[Step 3] Performing Check-Out...");

        // الفاتورة تتحسب هنا جوا الـ Workflow عن طريق الـ Strategy
        double bill = billingContext.calculateBill(booking, nights);
        
          // Adapter Pattern: تمرير الدفع للنظام القديم
        System.out.println("\n--- Payment Processing (Adapter Pattern) ---");
        paymentProcessor.processPayment(booking.getFullName(), bill);
        

        System.out.println("  Goodbye, " + booking.getFullName() + "!");
        System.out.println("  Room key returned.");
        System.out.println("  Final Bill: $" + String.format("%.2f", bill));
        System.out.println("  Payment confirmed.");
        System.out.println("  Thank you for staying at " + Config.getInstance().getHotelName() + "!");
    }
    @Override
    protected void notifyGuest(BookingRoom booking) {
        System.out.println("\n[Step 5] Sending notifications...");
        eventManager.publish(new PaymentEvent(),  booking.getFullName()); // إشعار الدفع
        eventManager.publish(new CheckOutEvent(), booking.getFullName()); // إشعار الخروج
    }

    @Override
    protected void logToSystem(BookingRoom booking) {
        System.out.println("[Step 6] Logging check-out to system...");
        System.out.println("  Departure date: " + booking.getDepartureDate());
        System.out.println("  Room [" + booking.getRoom().getDetails() + "] marked as AVAILABLE.");
        System.out.println("  Invoice archived.");
    }
}
