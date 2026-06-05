/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Observer;

import Observer.Events.Event;

/**
  * @author Raghad Saqallah 
 * ID:220232444
 */
public interface EventListener {
    // event type ,  guest name
    public void update(Event event , String name);

}
