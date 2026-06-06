/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Observer;
import Observer.Events.Event;

public class GuestObserver implements NotificationListener {
    @Override
    public void update(Event event, String guestName) {
        System.out.println("[Guest Notification] Hello " + guestName + "! " + event.getMessage());
    }
}