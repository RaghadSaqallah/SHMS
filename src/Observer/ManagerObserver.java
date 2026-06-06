/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer;
import Observer.Events.Event;

public class ManagerObserver implements NotificationListener {
    @Override
    public void update(Event event, String guestName) {
        // المدير يراقبه كل شيء ويصله نص الحدث مباشرة
        System.out.println("[Manager Report] System Event Logged for Guest: " + guestName + " -> " + event.getMessage());
    }
}