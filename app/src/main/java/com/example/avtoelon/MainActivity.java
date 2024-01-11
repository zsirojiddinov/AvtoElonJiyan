package com.example.avtoelon;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.avtoelon.fragment.AllFragment;
import com.example.avtoelon.fragment.LikeFragment;
import com.example.avtoelon.listener.IOpenInfoActivityListener;
import com.example.avtoelon.model.AutoCar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IOpenInfoActivityListener {

    private ArrayList<AutoCar> autoList;

    AppCompatButton saveBtn;
    AppCompatButton homeBtn;
   // DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        homeBtn = findViewById(R.id.home_btn);

        saveBtn = findViewById(R.id.saved_btn);

        writeDatabase();

        //     setAllFragment();

        homeBtn.setOnClickListener(v -> {
            //  setAllFragment();

          /*  ArrayList<AutoModel> autoList1 = dbHelper.getAutoList();
            Log.d("admin123", "- " + autoList1.size());*/
        });
        saveBtn.setOnClickListener(v -> setLikeFragment());

    }

    private void writeDatabase() {


    }

    private void setLikeFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mainFrame, LikeFragment.getInstance(this))
                .commit();
    }

    AllFragment instance;

    private void setAllFragment() {
        instance = AllFragment.getInstance(this);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mainFrame, instance)
                .commit();
    }

    private void onButtonClick(AppCompatButton button, Class activity) {
        button.setOnClickListener(view -> {
            Intent intent = new Intent(this, activity);
            startActivity(intent);
//            finish();
        });

    }

    @Override
    public void openInfoActivity(AutoCar car) {
        Log.d("admin123", "davay");
        Log.d("admin123", car.toString());
        Toast.makeText(this, car.getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtra("car", car);
        startActivity(intent);
    }
}