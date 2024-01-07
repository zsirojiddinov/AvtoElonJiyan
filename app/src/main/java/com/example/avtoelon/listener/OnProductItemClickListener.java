package com.example.avtoelon.listener;

import com.example.avtoelon.model.AutoCar;

public interface OnProductItemClickListener {
    void onItemClick(AutoCar car, int position);

    void onItemDelete(AutoCar car, int position);
}
