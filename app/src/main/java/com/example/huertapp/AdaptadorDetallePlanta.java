package com.example.huertapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdaptadorDetallePlanta extends BaseAdapter {

    Context context;
    int[] foto;
    String[] nombre;

    LayoutInflater inflater;

    public AdaptadorDetallePlanta(Context context, int[] foto, String[] nombre) {
        this.context = context;
        this.foto = foto;
        this.nombre = nombre;
    }

    @Override
    public int getCount() {
        return nombre.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (view == null) {
            view = inflater.inflate(R.layout.activity_adaptador_detalle_planta, null);
        }

        ImageView fotoObj = view.findViewById(R.id.fotoID);
        TextView nombreObj = view.findViewById(R.id.nombreID);

        fotoObj.setImageResource(foto[position]);
        nombreObj.setText(nombre[position]);
        return view;
    }
}
