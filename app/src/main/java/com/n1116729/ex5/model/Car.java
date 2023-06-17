package com.n1116729.ex5.model;

public class Car extends Transportation{
    public String name = "汽車";
    public Car(){
        totalEarnings = 0;
    }

    @Override
    public String transport(int rentalPrice) {
        totalEarnings += rentalPrice;
        return name;
    }

    @Override
    public boolean canRent(int rentalPrice) {
        return rentalPrice >= 2000 && rentalPrice <= 29999;
    }
}
