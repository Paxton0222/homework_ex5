package com.n1116729.ex5;

import java.util.List;

public class RentalRecord {
    private final int rentalCount;
    private final int rentalPrice;
    private final String vehicleType;
    private final String attendanceRates;
    private final int totalEarnings;

    public RentalRecord (int rentalCount, int rentalPrice, String vehicleType, String attendanceRates,int totalEarnings) {
        this.rentalCount = rentalCount;
        this.rentalPrice = rentalPrice;
        this.vehicleType = vehicleType;
        this.attendanceRates = attendanceRates;
        this.totalEarnings = totalEarnings;
    }

    public int getRentalCount() {
        return rentalCount;
    }

    public int getRentalPrice() { return rentalPrice; }

    public int getTotalEarnings() {
        return totalEarnings;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getAttendanceRates() {
        return attendanceRates;
    }
}
