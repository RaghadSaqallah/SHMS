/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package FactoryMethod;

/**
 * @author Raghad Saqallah
 * ID:220232444
 */
public class StanderdRoomFactory implements RoomFactory{

    @Override
    public Room createRoom() {
        return new StandardRoom();
    }

}
