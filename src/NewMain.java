import Builder.BookingRoom;
import FactoryMethod.*;
import Observer.*;
import Observer.Events.BookingEvent;
import Singleton.Config;
import Strategy.*;
import TemplateMethod.*;
import java.util.Locale;
import java.io.PrintStream;

/**
 * NewMain — نقطة دخول النظام
 *
 *  1. System configuration is loaded
 *  2. Room types are created
 *  3. Guest booking is constructed
 *  4. Booking confirmation triggers notifications
 *  5. Check-in workflow begins
 *  6. Billing strategy is selected dynamically
 *  7. Optional room upgrade (strategy change)
 *  8. Check-out completes and notifications are sent
 *     (Payment via Adapter + PaymentEvent + CheckOutEvent داخل CheckOutWorkflow)
 */
public class NewMain {

    public static void main(String[] args) {

        // ════════════════════════════════════════════════════════
        // إصلاح encoding — يضمن ظهور الأرقام والرموز بشكل صحيح
        // ════════════════════════════════════════════════════════
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (Exception e) {
            // fallback: continue without UTF-8 override
        }
        Locale.setDefault(Locale.ENGLISH);

        // ════════════════════════════════════════════════════════
        // STEP 1 — Singleton: تحميل إعدادات النظام
        // ════════════════════════════════════════════════════════
        Config config = Config.getInstance();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║   " + config.getHotelName() + " — System Starting   ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("Currency : " + config.getCurrency());
        System.out.println("Tax Rate : " + (config.getTaxRate() * 100) + "%");
        System.out.println("Check-In from  : " + config.getCheckInHour()  + ":00 PM");
        System.out.println("Check-Out by   : " + config.getCheckOutHour() + ":00 AM");

        // ════════════════════════════════════════════════════════
        // Observer Setup — تسجيل المشتركين (يجب يكون قبل أي حدث)
        // ════════════════════════════════════════════════════════
        System.out.println("\n--- Notification System Setup (Observer Pattern) ---");
        EventManager eventManager = new EventManager();
        eventManager.subscribe(new GuestObserver());
        eventManager.subscribe(new StaffObserver());
        eventManager.subscribe(new ManagerObserver());
        System.out.println("  ✔ Guest, Staff, and Manager observers registered.");

        // ════════════════════════════════════════════════════════
        // STEP 2 — Factory Method: إنشاء غرفة
        // ════════════════════════════════════════════════════════
        System.out.println("\n--- Room Creation (Factory Method) ---");
        RoomFactory factory = new DeluxeRoomFactory();
        Room room = factory.createRoom();
        room.displayInfo();

        // ════════════════════════════════════════════════════════
        // STEP 3 — Builder: بناء الحجز
        // ════════════════════════════════════════════════════════
        System.out.println("\n--- Booking Construction (Builder Pattern) ---");
        BookingRoom booking = new BookingRoom.Builder(room, "Sara Ahmed", "6-10-2026", "6-15-2026")
                .setBreakfast(true)
                .setLunch(false)
                .setDinner(true)
                .setDessert(true)
                .build();
        booking.printBookingInfo();

        // ════════════════════════════════════════════════════════
        // STEP 4 — Observer: إشعار تأكيد الحجز (BookingEvent)
        // ════════════════════════════════════════════════════════
        System.out.println("\n--- Booking Confirmation Notification (Observer) ---");
        eventManager.publish(new BookingEvent(), booking.getFullName());

        // ════════════════════════════════════════════════════════
        // STEP 5 — Template Method: Check-In Workflow
        //          (بداخله CheckInEvent عبر Observer)
        // ════════════════════════════════════════════════════════
        HotelWorkflow checkIn = new CheckInWorkflow(eventManager);
        checkIn.executeWorkflow(booking);

        // ════════════════════════════════════════════════════════
        // STEP 6 — Strategy: اختيار استراتيجية الفوترة
        // ════════════════════════════════════════════════════════
        System.out.println("\n--- Billing Strategy Selection (Strategy Pattern) ---");
        BillingContext billing = new BillingContext(new MemberDiscountStrategy());
        System.out.println("  ✔ Strategy selected: Member Discount (20% OFF)");

        // ════════════════════════════════════════════════════════
        // STEP 7 — Optional Room Upgrade: تغيير الاستراتيجية runtime
        //          (يُظهر مرونة الـ Strategy Pattern)
        // ════════════════════════════════════════════════════════
        System.out.println("\n--- Optional Upgrade: Switching to Seasonal Pricing ---");
        billing.setStrategy(new SeasonalPricingStrategy());

        // ════════════════════════════════════════════════════════
        // STEP 8 — Template Method: Check-Out Workflow
        //          بداخله: Strategy (حساب الفاتورة) +
        //                  Adapter (دفع عبر Legacy System) +
        //                  PaymentEvent + CheckOutEvent
        // ════════════════════════════════════════════════════════
        HotelWorkflow checkOut = new CheckOutWorkflow(billing, 5, eventManager);
        checkOut.executeWorkflow(booking);

        System.out.println("=================================");
        System.out.println(" System completed successfully.    ");
        System.out.println("==================================");
    }
}
