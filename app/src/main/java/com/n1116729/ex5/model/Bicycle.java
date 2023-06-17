package com.n1116729.ex5.model;

public class Bicycle extends  Transportation {
    public String name = "腳踏車";
    public Bicycle() {
        totalEarnings = 0;
    }

    @Override
    public String transport(int rentalPrice){
        totalEarnings += rentalPrice;
        return name;
    }

    @Override
    public boolean canRent(int rentalPrice) {
        return rentalPrice >= 100 && rentalPrice <= 499;
    }
}
