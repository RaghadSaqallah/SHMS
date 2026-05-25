/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package FactoryMethod;

/**
 *
 * @author AL
 */
public class StanderdRoomFactory implements RoomFactory{

    @Override
    public Room createRoom() {
        return new StandardRoom();
    }

}
