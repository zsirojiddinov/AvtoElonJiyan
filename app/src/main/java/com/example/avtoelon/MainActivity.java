package com.example.avtoelon;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.avtoelon.data.AutoCarDatabase;
import com.example.avtoelon.data.Data;
import com.example.avtoelon.fragment.AllFragment;
import com.example.avtoelon.fragment.LikeFragment;
import com.example.avtoelon.listener.IOpenInfoActivityListener;
import com.example.avtoelon.model.AutoCar;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity implements IOpenInfoActivityListener {

    private ArrayList<AutoCar> autoList;

    AppCompatButton saveBtn;
    AppCompatButton homeBtn;
    // DbHelper dbHelper;

    AutoCarDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        homeBtn = findViewById(R.id.home_btn);

        saveBtn = findViewById(R.id.saved_btn);

        RoomDatabase.Callback myCallBack = new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
            }

            @Override
            public void onOpen(@NonNull SupportSQLiteDatabase db) {
                super.onOpen(db);
            }
        };

        database = Room.databaseBuilder(getApplicationContext(),
                        AutoCarDatabase.class,
                        "autocardb")
                .addCallback(myCallBack)
                .build();


        writeDatabase();

        setAllFragment();

        homeBtn.setOnClickListener(v -> {
            getBackgroundService();
            setAllFragment();

          /*  ArrayList<AutoModel> autoList1 = dbHelper.getAutoList();
            Log.d("admin123", "- " + autoList1.size());*/
        });
        saveBtn.setOnClickListener(v -> setLikeFragment());

    }

    private void writeDatabase() {


        autoList = Data.getAutoList();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executorService.execute(() -> {

            List<AutoCar> allAutoCar = database.getAutoCarDao().getAllAutoCar();
            if (allAutoCar.size() == 0) {
                for (int i = 0; i < autoList.size(); i++) {
                    //  addBackgroundService();
                    database.getAutoCarDao().addAutoCar(autoList.get(i));
                }
            }
            handler.post(() -> {

            });
        });


        //  Log.d("admin123123", "123" + database.getAutoCarDao().getAllAutoCar().size());
    }

    private void getBackgroundService() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executorService.execute(() -> {
            List<AutoCar> allAutoCar = database.getAutoCarDao().getAllAutoCar();
            handler.post(() -> {
                Log.d("admin123", "123 - " + allAutoCar.size());
            });
        });
    }

    private void setLikeFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mainFrame, LikeFragment.getInstance(this))
                .commit();
    }


    private void setAllFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mainFrame, AllFragment.getInstance(this))
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