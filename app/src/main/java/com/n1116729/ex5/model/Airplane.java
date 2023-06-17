package com.n1116729.ex5.model;

public class Airplane extends Transportation{
    public String name = "飛機";
    public Airplane() {
        totalEarnings = 0;
    }

    @Override
    public String transport(int rentalPrice) {
        totalEarnings += rentalPrice;
        return name;
    }

    @Override
    public boolean canRent(int rentalPrice) {
        return rentalPrice >= 30000 && rentalPrice <= 99999;
    }
}
