package com.example.avtoelon.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
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
import com.example.avtoelon.adapter.RvAdapter;
import com.example.avtoelon.data.AutoCarDatabase;
import com.example.avtoelon.listener.IOpenInfoActivityListener;
import com.example.avtoelon.listener.OnProductItemClickListener;
import com.example.avtoelon.model.AutoCar;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AllFragment extends Fragment implements OnProductItemClickListener {

    private static final String LIST_AVTO_ELON = "listAvtoElon";
    private List<AutoCar> list;

    private RecyclerView rv;
    RvAdapter adapter;
    private IOpenInfoActivityListener myListener;
    RoomDatabase.Callback myCallBack;
    AutoCarDatabase database;

    private AllFragment(Context context) {
        if (context instanceof IOpenInfoActivityListener)
            myListener = (IOpenInfoActivityListener) context;

    }

    public static AllFragment getInstance(Context context) {
        return new AllFragment(context);
    }

   /* public static AllFragment getInstance2(ArrayList<AutoCar> allList, Context context) {
        AllFragment fragment = new AllFragment(context);
        Bundle args = new Bundle();
        args.putParcelableArrayList(LIST_AVTO_ELON, allList);
        fragment.setArguments(args);
        return fragment;
    }*/

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


        database = Room.databaseBuilder(requireContext(),
                        AutoCarDatabase.class,
                        "autocardb")
                .addCallback(myCallBack)
                .build();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executorService.execute(() -> {
            List<AutoCar> allAutoCar = database.getAutoCarDao().getAllAutoCar();
            list.addAll(allAutoCar);
            handler.post(() -> {
            });
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all, container, false);
        initializationView(view);
        return view;
    }

    private void initializationView(View view) {
        rv = view.findViewById(R.id.rv);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        adapter = new RvAdapter(list, this);
        rv.setAdapter(adapter);
    }


    @Override
    public void onItemClick(AutoCar car, int position) {
        myListener.openInfoActivity(car);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onItemDelete(AutoCar car, int position) {
        list.remove(car);
        adapter.notifyDataSetChanged();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executorService.execute(() -> {
            database.getAutoCarDao().deleteAutoCar(car);
            handler.post(() -> {
            });
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onChangeLike(AutoCar car, int position) {
        Log.d("admin123", "onChangeLike");
        list.get(position).setLike(!list.get(position).isLike());

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executorService.execute(() -> {
            database.getAutoCarDao().updateAutoCar(list.get(position));
            handler.post(() -> {
            });
        });

        adapter.notifyDataSetChanged();

    }

}

