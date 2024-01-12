package com.example.avtoelon.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.avtoelon.R;
import com.example.avtoelon.adapter.RvAdapter2;
import com.example.avtoelon.data.AutoCarDatabase;
import com.example.avtoelon.listener.IOpenInfoActivityListener;
import com.example.avtoelon.listener.OnProductItemClickListener;
import com.example.avtoelon.model.AutoCar;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LikeFragment extends Fragment implements OnProductItemClickListener {


    List<AutoCar> list;
    private RecyclerView rv;
    private RvAdapter2 adapter;

    private IOpenInfoActivityListener myListener;

    private LikeFragment(Context context) {
        if (context instanceof IOpenInfoActivityListener)
            myListener = (IOpenInfoActivityListener) context;

    }

    AutoCarDatabase database;
    RoomDatabase.Callback myCallBack;

    public static LikeFragment getInstance(Context context) {
        return new LikeFragment(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = new ArrayList<>();

        myCallBack = new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
            }

            @Override
            public void onOpen(@NonNull SupportSQLiteDatabase db) {
                super.onOpen(db);
            }
        };


        database = Room.databaseBuilder(requireContext(), AutoCarDatabase.class, "autocardb").addCallback(myCallBack).build();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executorService.execute(() -> {
            List<AutoCar> allAutoCar = database.getAutoCarDao().getAllLikeAutoCar(true);
            list.addAll(allAutoCar);
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_like, container, false);
        initializationView(view);
        return view;
    }

    private void initializationView(View view) {
        rv = view.findViewById(R.id.rv);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        adapter = new RvAdapter2(list, this);
        rv.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AutoCar car, int position) {
        myListener.openInfoActivity(car);
    }

    @Override
    public void onItemDelete(AutoCar car, int position) {
// todo bu ishlamaydi
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onChangeLike(AutoCar car, int position) {

        adapter.notifyDataSetChanged();


        list.get(position).setLike(!list.get(position).isLike());

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executorService.execute(() -> {
            database.getAutoCarDao().updateAutoCar(list.get(position));
            handler.post(() -> {
            });
        });

     //   list.remove(car);

        adapter.notifyDataSetChanged();
    }
}