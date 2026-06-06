/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Builder;

import FactoryMethod.Room;

/**
 *
 * @author Raghad Saqallah ID:220232444
 */
public class BookingRoom {

    private Room room; // نوع الغرفة التي تم حجزها
    private String fullName;
    private String arrivalDate; // موعد وصول
    private String departureDate; // موعد مغادرة
    private boolean dinner;
    private boolean breakfast;
    private boolean lunch;
    private boolean dessert;

    private BookingRoom(Builder b) {
        this.room = b.room;
        this.fullName = b.fullName;
        this.arrivalDate = b.arrivalDate;
        this.departureDate = b.departureDate;
        this.dinner = b.dinner;
        this.breakfast = b.breakfast;
        this.lunch = b.lunch;
        this.dessert = b.dessert;
    }

    public Room getRoom() {
        return room;
    }

    public String getFullName() {
        return fullName;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public boolean isDinner() {
        return dinner;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public boolean isLunch() {
        return lunch;
    }

    public boolean isDessert() {
        return dessert;
    }
    
    
    public void printBookingInfo(){
        System.out.println("Booking info:");
        System.out.println("Guest name:" + fullName);
        room.displayInfo();
        System.out.println("Arrival Date:" + arrivalDate + "\nDeparture Date:" + departureDate);
        System.out.println("Breakfast " +(breakfast ? "check" :"uncheck"));
        System.out.println("Lunch " +(lunch ? "check" :"uncheck"));
        System.out.println("Dinner " +(dinner ? "check" :"uncheck"));
        System.out.println("Dessert " +(dessert ? "check" :"uncheck"));
    
    }
    
    public static class Builder {
        private Room room;
        private String fullName;
        private String arrivalDate;
        private String departureDate;
        private boolean dinner;
        private boolean breakfast;
        private boolean lunch;
        private boolean dessert;

        // adding this constructor means that we cannot create object without these attributes 
        public Builder(Room room, String fullName, String arrivalDate, String departureDate) {
            this.room = room;
            this.fullName = fullName;
            this.arrivalDate = arrivalDate;
            this.departureDate = departureDate;
        }

        public Builder setRoom(Room room) {
            this.room = room;
            return this;
        }

        public Builder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder setArrivalDate(String arrivalDate) {
            this.arrivalDate = arrivalDate;
            return this;
        }

        public Builder setDepartureDate(String departureDate) {
            this.departureDate = departureDate;
            return this;
        }

        public Builder setDinner(boolean dinner) {
            this.dinner = dinner;
            return this;
        }

        public Builder setBreakfast(boolean breakfast) {
            this.breakfast = breakfast;
            return this;
        }

        public Builder setLunch(boolean lunch) {
            this.lunch = lunch;
            return this;
        }

        public Builder setDessert(boolean dessert) {
            this.dessert = dessert;
            return this;
        }

        public BookingRoom build() {
            //validetor for null and empty
            if (room == null || fullName == null || arrivalDate == null
                    || departureDate == null || fullName.isEmpty() || arrivalDate.isEmpty() || departureDate.isEmpty()) {
                throw new IllegalStateException("you must enter room type , a full name ,arrival Date and departure Date ");
            }

            return new BookingRoom(this);
        }

    }

}
