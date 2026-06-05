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
// listener type

public class Guest implements EventListener{
    private String name ;  // guest name

    public Guest(String name) {
        this.name = name;
    }

    @Override
    public void update(Event event, String guestName) {
        System.out.println("Gust: " + event.message(guestName));
    }
    


}
