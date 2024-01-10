package com.example.avtoelon.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.avtoelon.R;
import com.example.avtoelon.adapter.RvAdapter;
import com.example.avtoelon.listener.IOpenInfoActivityListener;
import com.example.avtoelon.listener.OnProductItemClickListener;
import com.example.avtoelon.model.AutoCar;
import com.example.avtoelon.model.AutoModel;
import com.example.avtoelon.service.DbHelper;

import java.util.ArrayList;

public class AllFragment extends Fragment implements OnProductItemClickListener {

    private static final String LIST_AVTO_ELON = "listAvtoElon";
    private ArrayList<AutoModel> list;

    private RecyclerView rv;
    RvAdapter adapter;
    DbHelper dbHelper;
    private IOpenInfoActivityListener myListener;

    private AllFragment(Context context) {
        if (context instanceof IOpenInfoActivityListener)
            myListener = (IOpenInfoActivityListener) context;

    }

    public static AllFragment getInstance(Context context) {
        return new AllFragment(context);
    }

    public static AllFragment getInstance2(ArrayList<AutoCar> allList, Context context) {
        AllFragment fragment = new AllFragment(context);
        Bundle args = new Bundle();
        args.putParcelableArrayList(LIST_AVTO_ELON, allList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        dbHelper = new DbHelper(requireContext());
        list = dbHelper.getAutoList();

        Log.d("admin123", list.size() + "");

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
    public void onItemClick(AutoModel car, int position) {
        myListener.openInfoActivity(car);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onItemDelete(AutoModel car, int position) {
        list.remove(car);
        adapter.notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onChangeLike(AutoModel car, int position) {
        list.get(position).setLike(list.get(position).isLike() == 1 ? 0 : 1);
        adapter.notifyDataSetChanged();
    }

    public ArrayList<AutoModel> getLikeList() {
        ArrayList<AutoModel> likeList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isLike() == 1) {
                likeList.add(list.get(i));
            }
        }

        return likeList;

    }
}

