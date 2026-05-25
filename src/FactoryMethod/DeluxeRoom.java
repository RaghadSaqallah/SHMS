/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FactoryMethod;

import Singleton.Config;
import java.util.Arrays;
import java.util.List;

/**
 * @author Raghad Saqallah
 * ID:220232444
 */ 
//room num 2
public class DeluxeRoom implements Room {

    @Override
    public double getPrice() {
        return 350 * (1 + Config.getInstance().getTaxRate());  // حساب السعر بالاضافة للضريبة

    }

    @Override
    public int getCapacity() {
        return 5;
    }

    @Override
    public String getDetails() {
        return "Deluxe Room";
    }

    @Override
    public List<String> getFeatures() {
        return Arrays.asList(
                "TV",
                "Air Conditioning",
                "Sea View"
        );
    }

}
