package com.n1116729.ex5;
import android.annotation.SuppressLint;

import com.n1116729.ex5.model.Airplane;
import com.n1116729.ex5.model.Bicycle;
import com.n1116729.ex5.model.Car;
import com.n1116729.ex5.model.Motorcycle;
import com.n1116729.ex5.model.Rocket;
import com.n1116729.ex5.model.Transportation;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class RentalCompany {
    private final List<Transportation> transportationTypes;
    private final List<RentalRecord> rentalRecords;

    public RentalCompany() {
        transportationTypes = new ArrayList<>();
        transportationTypes.add(new Bicycle());
        transportationTypes.add(new Motorcycle());
        transportationTypes.add(new Car());
        transportationTypes.add(new Airplane());
        transportationTypes.add(new Rocket());

        rentalRecords = new ArrayList<>();
    }

    public void rentVehicle(int rentalPrice) {
        Transportation vehicle = getVehicle(rentalPrice);
        assert vehicle != null;
        int rentalCount = rentalRecords.size() + 1;
        String vehicleName = vehicle.transport(rentalPrice);
        int totalEarnings = getTotalEarnings();
        String attendanceRates = calculateAttendanceRates(vehicle,vehicleName);

        rentalRecords.add(new RentalRecord(rentalCount, rentalPrice,vehicleName , attendanceRates, totalEarnings));
    }

    private Transportation getVehicle(int rentalPrice) {
        for (Transportation vehicle : transportationTypes) {
            if (vehicle.canRent(rentalPrice)) {
                return vehicle;
            }
        }
        return null;
    }

    private int getVehicleTotalTransportCount(String vehicleName) {
        int totalTransportCount = 1;
        for (RentalRecord rentalRecord : rentalRecords) {
            if (rentalRecord.getVehicleType().equals(vehicleName)) {
                totalTransportCount += 1;
            }
        }
        System.out.println("total:" +String.valueOf(totalTransportCount));
        return totalTransportCount;
    }

    private int getTotalEarnings() {
        int totalEarnings = 0;
        for (Transportation vehicle : transportationTypes) {
            totalEarnings += vehicle.getTotalEarnings();
        }
        return totalEarnings;
    }

    @SuppressLint("DefaultLocale")
    private String calculateAttendanceRates(Transportation currentVehicle,String vehicleName){
        StringBuilder attendanceRates = new StringBuilder();
        double attendanceRate = (double) getVehicleTotalTransportCount(vehicleName) / (rentalRecords.size()+1) * 100;
        attendanceRates.append(MessageFormat.format("{0}: {1}%", vehicleName, String.format("%.2f", attendanceRate)));
        return attendanceRates.toString();
    }

    public List<RentalRecord> getRentalRecords() {
        return rentalRecords;
    }

    public void clearRentalRecords() {
        rentalRecords.clear();
        for (Transportation vehicle : transportationTypes) {
            vehicle.setTotalEarnings(0);
        }
    }

}
