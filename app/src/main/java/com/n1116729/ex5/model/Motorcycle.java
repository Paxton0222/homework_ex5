package com.n1116729.ex5.model;

public class Motorcycle extends Transportation{
    public String name = "摩托車";
    public Motorcycle() {
        totalEarnings = 0;
    }

    @Override
    public String transport(int rentalPrice) {
       totalEarnings += rentalPrice;
       return name;
    }

    @Override
    public boolean canRent(int rentalPrice) {
        return rentalPrice >= 500 && rentalPrice <= 1999;
    }
}
