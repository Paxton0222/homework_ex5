package com.n1116729.ex5;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.n1116729.ex5.adapters.RentalListAdapter;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private RentalCompany rentalCompany;
    private RentalListAdapter rentalListAdapter;

    private EditText numRentalsEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rentalCompany = new RentalCompany();

        numRentalsEditText = findViewById(R.id.numRentalsEditText);
        Button simulateButton = findViewById(R.id.simulateButton);
        ListView rentalListView = findViewById(R.id.rentalListView);

        simulateButton.setOnClickListener(this::onClick);

        rentalListAdapter = new RentalListAdapter(this, rentalCompany.getRentalRecords());
        rentalListView.setAdapter(rentalListAdapter);
    }

    private void simulateRentals(int numRentals) {
        Random random = new Random();
        rentalCompany.clearRentalRecords();
        for (int i = 0; i < numRentals; i++) {
            int rentalPrice = random.nextInt(200001 - 100) + 100;
            rentalCompany.rentVehicle(rentalPrice);
        }
    }

    private void onClick(View v) {
        if (!TextUtils.isEmpty(numRentalsEditText.getText())) {
            int numRentals = Integer.parseInt(numRentalsEditText.getText().toString());
            simulateRentals(numRentals);
            rentalListAdapter.notifyDataSetChanged();
        }
    }
}
