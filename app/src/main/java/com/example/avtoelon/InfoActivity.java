package com.example.avtoelon;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.avtoelon.model.AutoCar;
import com.squareup.picasso.Picasso;

import java.io.Serializable;

public class InfoActivity extends AppCompatActivity {

    private TextView titleTv;
    private ImageView image;
    private TextView carName;
    private TextView carPrice;
    private TextView regionTv;
    private TextView yearTv;
    private TextView odometerTv;
    private TextView colorTv;
    private ImageView backButton;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent intent = getIntent();
        AutoCar car = (AutoCar) intent.getSerializableExtra("car");

        titleTv = findViewById(R.id.titleTv);
        image = findViewById(R.id.carImage);
        carName = findViewById(R.id.carName);
        carPrice = findViewById(R.id.carPrice);
        regionTv = findViewById(R.id.regionTv);
        yearTv = findViewById(R.id.yiliTv);
        odometerTv = findViewById(R.id.odometerTv);
        colorTv = findViewById(R.id.colorTv);
        backButton = findViewById(R.id.backBtn);

        Picasso.get().load(car.getImageList().get(1)).into(image);
        carName.setText(car.getName());
        carPrice.setText((int) car.getPrice() + " $");
        regionTv.setText(car.getRegion());
        yearTv.setText(car.getYear());
        odometerTv.setText(car.getOdometer());
        colorTv.setText(car.getColor());
        titleTv.setText(car.getName());

//        backButton.setOnClickListener(view -> finish());
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(InfoActivity.this);

                alertDialogBuilder.setTitle("AlertDialog");
                alertDialogBuilder.setMessage("Confirm to exit").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        InfoActivity.this.finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog=alertDialogBuilder.create();
                alertDialog.show();
            }
        });
    }
}