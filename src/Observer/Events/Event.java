/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Observer.Events;

/**
 * @author Raghad Saqallah 
 * ID:220232444
 * 
*/
//انوع الايفينت الي هيتم اشعارنا بها
//عشان يكونوا من نفس النوع
// لو بدنا نضيف افينت جديد بس  implements
// event interface (parent)
public interface Event {
    public String message(String name); // اسم الجيست
}
