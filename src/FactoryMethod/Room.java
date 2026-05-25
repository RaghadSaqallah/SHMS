/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FactoryMethod;

import java.util.List;

/**
 *
 * @author Raghad Saqallah ID:220232444
 */
//All room types implement form this interface
public interface Room {

    public double getPrice();

    public int getCapacity();

    public String getDetails();

    public List<String> getFeatures();
    

    default void displayInfo() {
        System.out.println("Room Details: " + getDetails());
        System.out.println("Capacity: " + getCapacity());
        System.out.println("Price: " + String.format("%.2f", getPrice()));
        System.out.println("Features:" + getFeatures());
    }

}
