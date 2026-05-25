package Singleton;

/**
 *
 * @author Raghad Saqallah ID:220232444
 *
 */
public class Config {
//Singleton Pattern System Configuration

    private String hotelName;  // اسم الهوتيل
    private String currency;  // العملة
    private double taxRate; // نسبة الضريبة 

    private int checkInHour;  // الوقت الي الغرفة هتكون جاهزة لاستقبال الضيف(الغرفة جاهزة لاستقبال)
    private int checkOutHour;  // وقت مغادة الضيف

    private Config() {
        this.hotelName = "HDR Hotel";
        this.currency = "USD";
        this.taxRate = 0.15;
        this.checkInHour = 3;  //pm
        this.checkOutHour = 11; //am
    }

    private static Config instance;

    public static synchronized Config getInstance() {  // السينجيلتون
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getCurrency() {
        return currency;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public int getCheckInHour() {
        return checkInHour;
    }

    public int getCheckOutHour() {
        return checkOutHour;
    }

    // اذا بدكم تغيرو الوقت
    public void setCheckInHour(int checkInHour) {
        this.checkInHour = checkInHour;
    }

    public void setCheckOutHour(int checkOutHour) {
        this.checkOutHour = checkOutHour;
    }

    // هل يمكن للغرفة استقبال الضيف ام لا 
    public boolean isCheckInValid(int hour) {
      return hour >= this.checkInHour;
        
    }
}
