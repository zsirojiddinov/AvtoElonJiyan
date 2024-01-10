package com.example.avtoelon.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.avtoelon.R;
import com.example.avtoelon.adapter.RvAdapter2;
import com.example.avtoelon.listener.OnProductItemClickListener;
import com.example.avtoelon.model.AutoCar;

import java.util.ArrayList;

public class LikeFragment extends Fragment implements OnProductItemClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String LIST_AUTO = "listAuto";

    ArrayList<AutoCar> list;
    private RecyclerView rv;
    private RvAdapter2 adapter;

    public LikeFragment(Context context) {
    }

    public static LikeFragment getInstance(ArrayList<AutoCar> list, Context context) {
        LikeFragment fragment = new LikeFragment(context);
        Bundle args = new Bundle();
        args.putParcelableArrayList(LIST_AUTO, list);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            list = getArguments().getParcelableArrayList(LIST_AUTO);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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

    }

    @Override
    public void onItemDelete(AutoCar car, int position) {
// todo bu ishlamaydi
    }

    @Override
    public void onChangeLike(AutoCar car, int position) {

    }
}