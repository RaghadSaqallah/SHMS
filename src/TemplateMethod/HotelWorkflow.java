package TemplateMethod;
import Builder.BookingRoom;
import Observer.EventManager;

/**
 * HotelWorkflow - Template Method Pattern (Abstract Class)
 * 
 * هذا الكلاس يحدد الهيكل الثابت للـ Workflow (الخطوات بالترتيب)
 * بعض الخطوات ثابتة لكل الـ workflows (final)
 * بعض الخطوات تختلف حسب نوع الـ workflow (abstract)
 * 
 * القاعدة: لا يمكن تغيير الترتيب، فقط تغيير تفاصيل بعض الخطوات
 * 
 * @author [اسمك]
 */
public abstract class HotelWorkflow {
    protected EventManager eventManager; // كائن الناشر (Publisher)
// تمرير الـ Manager من الخارج (Dependency Injection) 
   public HotelWorkflow(EventManager eventManager) {
    this.eventManager = eventManager;
}

  
    /**
     * ==========================================
     * TEMPLATE METHOD - الهيكل الثابت للـ Workflow
     * هذا الميثود final = لا يمكن تغيير الترتيب أبداً
     * ==========================================
     */
    public final void executeWorkflow(BookingRoom booking) {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║  Starting: " + getWorkflowName());
        System.out.println("╚══════════════════════════════════════╝");

        // الخطوة 1: التحقق من البيانات (ثابتة لكل workflow)
        validateBooking(booking);

        // الخطوة 2: التحضير (تختلف بين check-in و check-out)
        prepareProcess(booking);

        // الخطوة 3: تسجيل الدخول أو الخروج (تختلف)
        performMainAction(booking);

        // الخطوة 4: معالجة الخدمات (ثابتة)
        processServices(booking);

        // الخطوة 5: إرسال إشعار للضيف (ثابتة)
        notifyGuest(booking);

        // الخطوة 6: تسجيل في النظام (تختلف)
        logToSystem(booking);

        System.out.println("\n✔ Workflow [" + getWorkflowName() + "] completed successfully.\n");
    }

    // ميثود التنبيه التي تستخدم نمط الـ Observer 
      protected abstract void notifyGuest(BookingRoom booking);
    
 
   
    // ============================================
    // الخطوات الثابتة - نفس التنفيذ في كل workflow
    // ============================================

    /**
     * التحقق من صحة بيانات الحجز (نفسها في كل workflow)
     */
    private void validateBooking(BookingRoom booking) {
        System.out.println("\n[Step 1] Validating booking...");
        if (booking == null) {
            throw new IllegalArgumentException("Booking cannot be null!");
        }
        System.out.println("  ✔ Guest     : " + booking.getFullName());
        System.out.println("  ✔ Room      : " + booking.getRoom().getDetails());
        System.out.println("  ✔ Arrival   : " + booking.getArrivalDate());
        System.out.println("  ✔ Departure : " + booking.getDepartureDate());
        System.out.println("  ✔ Booking validated successfully.");
    }

    /**
     * معالجة الخدمات المطلوبة (وجبات) - ثابتة في كل workflow
     */
    private void processServices(BookingRoom booking) {
        System.out.println("\n[Step 4] Processing requested services...");
        if (booking.isBreakfast()) System.out.println("  ✔ Breakfast service added.");
        if (booking.isLunch())     System.out.println("  ✔ Lunch service added.");
        if (booking.isDinner())    System.out.println("  ✔ Dinner service added.");
        if (booking.isDessert())   System.out.println("  ✔ Dessert service added.");

        if (!booking.isBreakfast() && !booking.isLunch()
                && !booking.isDinner() && !booking.isDessert()) {
            System.out.println("  ℹ No additional services requested.");
        }
    }

   
    
     

    // ============================================
    // الخطوات المجردة - تختلف بين Check-in و Check-out
    // ============================================

    /**
     * اسم الـ Workflow للعرض
     */
    protected abstract String getWorkflowName();

    /**
     * خطوة التحضير - تختلف
     */
    protected abstract void prepareProcess(BookingRoom booking);

    /**
     * الإجراء الرئيسي (دخول أو خروج) - تختلف
     */
    protected abstract void performMainAction(BookingRoom booking);

    /**
     * التسجيل في النظام - تختلف
     */
    protected abstract void logToSystem(BookingRoom booking);
}
