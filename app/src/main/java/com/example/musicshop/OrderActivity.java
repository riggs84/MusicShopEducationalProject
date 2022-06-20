package com.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        setTitle("My Order");

        Intent receivedIntent = getIntent();
        TextView customerNameTextView = findViewById(R.id.customerNameTextView);
        TextView itemNameTextView = findViewById(R.id.itemNameTextView);
        TextView quantityTextView = findViewById(R.id.quantityTextView);
        TextView priceTextView = findViewById(R.id.priceTextView);
        TextView orderPriceTextView = findViewById(R.id.oderPriceTextView);
        Log.d("azaza", receivedIntent.getStringExtra("itemName"));

        customerNameTextView.setText("Customer name: " + receivedIntent.getStringExtra("customerName"));
        itemNameTextView.setText("Goods name: " + receivedIntent.getStringExtra("itemName"));
        quantityTextView.setText("Quantity: " + receivedIntent.getIntExtra("quantity", 0));
        priceTextView.setText("Price: " + receivedIntent.getDoubleExtra("price", 0.0));
        orderPriceTextView.setText("Total: " + receivedIntent.getDoubleExtra("total", 0.0));
    }
}