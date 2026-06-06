/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


// الواجهة الموحدة لكل المستمعين (Subscribers)
package Observer;
import Observer.Events.Event;

public interface NotificationListener {
    void update(Event event, String guestName);
}