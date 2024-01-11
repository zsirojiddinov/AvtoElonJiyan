package com.example.avtoelon;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.avtoelon.data.Data;
import com.example.avtoelon.fragment.AllFragment;
import com.example.avtoelon.fragment.LikeFragment;
import com.example.avtoelon.listener.IOpenInfoActivityListener;
import com.example.avtoelon.model.AutoCar;
import com.example.avtoelon.model.AutoModel;
import com.example.avtoelon.service.DbHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IOpenInfoActivityListener {

    private ArrayList<AutoCar> autoList;

    AppCompatButton saveBtn;
    AppCompatButton homeBtn;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        homeBtn = findViewById(R.id.home_btn);

        saveBtn = findViewById(R.id.saved_btn);

     //   writeDatabase();

   //     setAllFragment();

        homeBtn.setOnClickListener(v -> setAllFragment());
        saveBtn.setOnClickListener(v -> setLikeFragment());

    }

    private void writeDatabase() {

        dbHelper = new DbHelper(this);
        ArrayList<AutoModel> models = getAutoModel();
        for (int i = 0; i < models.size(); i++) {
            if (dbHelper.insertAutoModel(models.get(i)) != 0) {
                Log.d("admin123", "++++");
            }else {
                Log.d("admin123", "----");

            }

        }
    }

    private ArrayList<AutoModel> getAutoModel() {
        autoList = Data.getAutoList();
        ArrayList<AutoModel> myList = new ArrayList<>();
        for (int i = 0; i < autoList.size(); i++) {
            myList.add(new AutoModel(autoList.get(i).getId(),
                    autoList.get(i).getName(), autoList.get(i).getYear(),
                    autoList.get(i).getRegion(), autoList.get(i).getOdometer(),
                    autoList.get(i).getPrice(), autoList.get(i).getPublishedDate(),
                    autoList.get(i).getShow_count(),
                    autoList.get(i).getImageList().get(0),
                    autoList.get(i).isLike() ? 1 : 0));
        }

        return myList;
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
    public void openInfoActivity(AutoModel car) {
        Log.d("admin123", "davay");
        Log.d("admin123", car.toString());
        Toast.makeText(this, car.getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtra("car", car);
        startActivity(intent);
    }
}