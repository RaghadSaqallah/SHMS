/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Observer.Events;

/**
 * @author Raghad Saqallah 
 * ID:220232444
 */
// event type

public class CheckInEvent implements Event{

    @Override
    public String message(String name) {
        return " Guest " + name  + ": your room is ready";
    }

}
