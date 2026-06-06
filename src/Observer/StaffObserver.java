/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Observer;
import Observer.Events.Event;

public class StaffObserver implements NotificationListener {
    @Override
    public void update(Event event, String guestName) {
        // يطبع التحديث القادم من الحدث مباشرة للموظفين
        System.out.println("[Staff Alert] Attention Team! For Guest [" + guestName + "]: " + event.getMessage());
    }}
