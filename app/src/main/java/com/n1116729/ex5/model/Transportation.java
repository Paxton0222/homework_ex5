package com.n1116729.ex5.model;

public abstract class Transportation {
    protected int totalEarnings;
    public String name;

    public int getTotalEarnings() {
        return totalEarnings;
    }
    public void setTotalEarnings(int totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

    public abstract String transport(int rentalPrice);

    public abstract boolean canRent(int rentalPrice);
}
