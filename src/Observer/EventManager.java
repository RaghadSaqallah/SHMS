/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer;

import Observer.Events.Event; // استيراد الواجهة الجديدة للأحداث
import java.util.ArrayList;
import java.util.List;

/**
 
 * المسؤول عن إدارة المشتركين وتوزيع الأحداث عليهم 
 */
public class EventManager {
    //  لتخزين كافة المستمعين 
    private List<NotificationListener> listeners = new ArrayList<>();

    // إضافة مشترك جديد
    public void subscribe(NotificationListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    // إلغاء الاشتراك 
    public void unsubscribe(NotificationListener listener) {
        listeners.remove(listener);
    }

     // تنفيذ عملية النشر (Publish)
    public void publish(Event event, String guestName) {
        for (NotificationListener listener : listeners) {
            // استدعاء ميثود التحديث لكل مشترك  دون الحاجة لمعرفة نوع الحدث
            listener.update(event, guestName);
        }
    }
}