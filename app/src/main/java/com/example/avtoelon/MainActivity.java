package com.example.avtoelon;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.avtoelon.adapter.RvAdapter;
import com.example.avtoelon.data.Data;
import com.example.avtoelon.fragment.AllFragment;
import com.example.avtoelon.listener.IOpenInfoActivityListener;
import com.example.avtoelon.model.AutoCar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IOpenInfoActivityListener {

    private ArrayList<AutoCar> autoList;

    RvAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoList = Data.getAutoList();
        //    RecyclerView recyclerView = findViewById(R.id.rv);
        //   AppCompatButton savedBtn = findViewById(R.id.saved_btn);

        //   SearchView searchView = findViewById(R.id.search_view);
        AppCompatButton homeBtn = findViewById(R.id.home_btn);

        setAllFragment();

       /* adapter = new RvAdapter(autoList, this);
        recyclerView.setAdapter(adapter);
        onButtonClick(savedBtn, SavedActivity.class);*/


    }

    private void setAllFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mainFrame, AllFragment.getInstance(autoList, this))
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