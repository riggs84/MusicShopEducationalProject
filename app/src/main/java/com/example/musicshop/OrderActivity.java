package com.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    private String customerName;
    private String itemName;
    private int quantity;
    private double price;
    private double total;

    private String[] addresses = { "azaza@mail.ru" };

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

        customerName = receivedIntent.getStringExtra("customerName");
        itemName = receivedIntent.getStringExtra("itemName");
        quantity = receivedIntent.getIntExtra("quantity", 0);
        price = receivedIntent.getDoubleExtra("price", 0.0);
        total = receivedIntent.getDoubleExtra("total", 0.0);

        customerNameTextView.setText("Customer name: " + customerName);
        itemNameTextView.setText("Goods name: " + itemName);
        quantityTextView.setText("Quantity: " + quantity);
        priceTextView.setText("Price: " + price);
        orderPriceTextView.setText("Total: " + total);
    }

    public void submitOrder(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Customer order");
        intent.putExtra(Intent.EXTRA_TEXT, getOrderBody());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private String getOrderBody() {
        return "Customer Name: " + customerName + "\n" + "Item Name: " + itemName + "\n" + "Quantity: "
                + quantity + "\n" + "Price: " + price + "\n" + "Total: " + total;
    }
}