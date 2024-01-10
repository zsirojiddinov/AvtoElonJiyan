package com.example.avtoelon.listener;

import com.example.avtoelon.model.AutoCar;
import com.example.avtoelon.model.AutoModel;

public interface OnProductItemClickListener {
    void onItemClick(AutoModel car, int position);

    void onItemDelete(AutoModel car, int position);

    void onChangeLike(AutoModel car, int position);
}
