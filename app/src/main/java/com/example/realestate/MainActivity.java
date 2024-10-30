package com.example.realestate;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.realestate.model.Listing;
import com.example.realestate.model.Property;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * MainActivity is the controller for the Real Estate application.
 * It handles user interactions, loads data from a CSV file using assetManager,
 * and displays property prices in response to button clicks using OnClickListener.
 *
 * @author Mahya Mottaghi
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // initializing the listing
        Listing listing = Listing.getInstance();

        // Load properties from the CSV file using loadProperty() method
        loadProperty("listings.csv");

        // Initialize buttons
        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);

        button.setText("Residential");
        button2.setText("Residential");
        button3.setText("Residential");
        button4.setText("Residential");

        // setting the property addresses to the buttons
        ArrayList<Property> properties = listing.getAllProperties();
        if (properties != null) {
            String address1 = properties.get(0).getLocation();
            String address2 = properties.get(1).getLocation();
            String address3 = properties.get(2).getLocation();
            String address4 = properties.get(3).getLocation();
            button.setText(address1);
            button2.setText(address2);
            button3.setText(address3);
            button4.setText(address4);
        }

        // setting the exit button to finish the activity
        Button exitButton = findViewById(R.id.EXButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });


        TextView textView = findViewById(R.id.textView2);

        //setting on click listeners for the buttons to display the property price
        button.setOnClickListener(v -> {

            String price = "Price: " + String.valueOf(properties.get(0).getPrice());
            Toast.makeText(this, price, Toast.LENGTH_SHORT).show();
            textView.setText(price);


        });

        button2.setOnClickListener(v -> {

            String price = "Price: " + String.valueOf(properties.get(1).getPrice());
            Toast.makeText(this, price, Toast.LENGTH_SHORT).show();
            textView.setText(price);


        });

        button3.setOnClickListener(v -> {

            String price = "Price: " + String.valueOf(properties.get(2).getPrice());
            Toast.makeText(this, price, Toast.LENGTH_SHORT).show();
            textView.setText(price);


        });
        button4.setOnClickListener(v -> {

            String price = "Price: " + String.valueOf(properties.get(3).getPrice());
            Toast.makeText(this, price, Toast.LENGTH_SHORT).show();
            textView.setText(price);


        });


    }

    /**
     * Loads property data from the specified CSV file using assetManager and invoking
     * loadProperties() method of Listing class.
     *
     * @param filename The name of the CSV file located in the assets folder.
     */
    public void loadProperty(String filename) {

        try {

            AssetManager assetManager = getAssets();
            InputStream inputStream = assetManager.open("listings.csv");

            Listing listings = Listing.getInstance();
            listings.loadProperties(inputStream);



        } catch (IOException e) {

            e.printStackTrace();
        }

    }


}