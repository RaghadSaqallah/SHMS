/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer.Events;

public class CheckOutEvent implements Event {
    @Override 
    public String getMessage() {
        return "Check-Out process has been completed successfully.";
    }
}

