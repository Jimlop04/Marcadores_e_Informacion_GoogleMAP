package com.example.marcadores_e_informacion_googlemap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;


public class AdapterMarcadores {

    private final View windowAdapter;
    private Context context;


    public AdapterMarcadores(Context context) {
        this.context = context;
        windowAdapter = LayoutInflater.from(context).inflate(R.layout.cardview_info, null);
    }





}

