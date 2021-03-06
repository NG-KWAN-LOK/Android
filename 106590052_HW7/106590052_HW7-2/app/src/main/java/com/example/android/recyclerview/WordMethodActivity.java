package com.example.android.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class WordMethodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_method);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String item_name = null;
        if (extras != null) {
            item_name = extras.getString(WordListAdapter.EXTRA_NAME);
        }
        TextView heading = findViewById(R.id.food_name);
        ImageView imageView = findViewById(R.id.food_image);
        heading.setText(item_name);
        if (item_name != null) {
            switch (item_name){
                case "Instant Pot® Carne Adovado":
                    imageView.setImageResource(R.drawable.carneadovado);
                    break;
                case "Blueberry Peach Cobbler":
                    imageView.setImageResource(R.drawable.cobbler);
                    break;
                case "Texas Sheet Cake":
                    imageView.setImageResource(R.drawable.sheet_cake);
                    break;
                case "Espresso Crinkles":
                    imageView.setImageResource(R.drawable.espresso_crinkles);
                    break;
                case "Chocolate Cherry Cookies":
                    imageView.setImageResource(R.drawable.chocolate_cherry_cookies);
                    break;
                case "Vanilla Cheesecake":
                    imageView.setImageResource(R.drawable.cheesecake);
                    break;
                case "Tiramisu":
                    imageView.setImageResource(R.drawable.tiramisu);
                    break;
                case "Carrot Cake":
                    imageView.setImageResource(R.drawable.carrot_cake);
                    break;
                case "Blueberry Ice Cream":
                    imageView.setImageResource(R.drawable.blueberry_ice_cream);
                    break;
                default: break;
            }
        }
    }
}