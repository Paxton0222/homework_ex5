package com.n1116729.ex5.model;

public class Rocket extends Transportation{
    public String name = "火箭";
    public Rocket() {
        totalEarnings = 0;
    }
    @Override
    public String transport(int rentalPrice) {
        totalEarnings += rentalPrice;
        return name;
    }

    @Override
    public boolean canRent(int rentalPrice) {
        return rentalPrice >= 100000;
    }
}
