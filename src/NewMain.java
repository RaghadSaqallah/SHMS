import Builder.BookingRoom;
import FactoryMethod.*;
import Singleton.Config;
import Strategy.*;
import TemplateMethod.*;

public class NewMain {

    public static void main(String[] args) {

        // ============================================================
        // STEP 1: Singleton - تحميل إعدادات النظام
        // ============================================================
        Config config = Config.getInstance();
        System.out.println("=== " + config.getHotelName() + " ===");
        System.out.println("Currency : " + config.getCurrency());
        System.out.println("Tax Rate : " + (config.getTaxRate() * 100) + "%");

        // ============================================================
        // STEP 2: Factory Method - إنشاء غرفة
        // ============================================================
        System.out.println("\n--- Room Creation (Factory Method) ---");
        RoomFactory factory = new DeluxeRoomFactory();
        Room room = factory.createRoom();
        room.displayInfo();

        // ============================================================
        // STEP 3: Builder - بناء الحجز
        // ============================================================
        System.out.println("\n--- Booking (Builder Pattern) ---");
        BookingRoom booking = new BookingRoom.Builder(room, "Sara Ahmed", "6-10-2026", "6-15-2026")
                .setBreakfast(true)
                .setLunch(false)
                .setDinner(true)
                .setDessert(true)
                .build();
        booking.printBookingInfo();

        // ============================================================
        // STEP 4: Template Method - Check-In
        // ============================================================
        HotelWorkflow checkIn = new CheckInWorkflow();
        checkIn.executeWorkflow(booking);

        // ============================================================
        // STEP 5: Strategy - اختيار استراتيجية الفوترة
        // ============================================================
        // الاستراتيجية تتحدد هنا وتنتقل للـ CheckOutWorkflow
        BillingContext billing = new BillingContext(new MemberDiscountStrategy());

        // ============================================================
        // STEP 6: Template Method - Check-Out (بيحسب الفاتورة جواه)
        // ============================================================
        HotelWorkflow checkOut = new CheckOutWorkflow(billing, 5);
        checkOut.executeWorkflow(booking);

        System.out.println("\n System completed successfully.");
        
    }
}