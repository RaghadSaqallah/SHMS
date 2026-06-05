/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Observer;

import Observer.Events.Event;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AL
 */
public class EventManager {
    private List<EventListener> list = new ArrayList();
    public void subscribe (EventListener listener){
        if(!list.contains(listener)){
            list.add(listener);
        }
    }
    
    public void unsubscribe (EventListener listener){
        list.remove(listener);
    }
    
    public void publish (Event event , String name){
        for(EventListener listener : list){
            listener.update(event, name);
        }
        
    }

}
