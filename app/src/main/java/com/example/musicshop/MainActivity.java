package com.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private int quantity = 0;
    private Double price = 0.0;
    private Spinner spinner;
    private ArrayAdapter arrayAdapter;
    private final List<String> spinnerData = Arrays.asList("GUITAR", "DRUM", "PIANO");
    private Map<String, Double> priceMap = new HashMap<String, Double>() {{
        put("GUITAR", 1000.0);
        put("DRUM", 250.10);
        put("PIANO", 720.15);
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerData);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner = findViewById(R.id.spinner);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void increaseButtonHandler(View view) {
        TextView quantityView = findViewById(R.id.quantityText);
        quantityView.setText(String.valueOf(++quantity));
        updatePriceInTextView();
    }

    public void decreaseButtonHandler(View view) {
        if (quantity < 1) {
            quantity = 0;
        } else {
            quantity--;
        }
        TextView quantityView = findViewById(R.id.quantityText);
        quantityView.setText(String.valueOf(quantity));
        updatePriceInTextView();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String selectedItem = spinner.getSelectedItem().toString();
        price = priceMap.get(selectedItem);
        updatePriceInTextView();
    }

    private void updatePriceInTextView() {
        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText(String.valueOf(price * quantity));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}