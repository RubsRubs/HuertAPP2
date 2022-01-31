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
    String[] accion;
    String[] observacion;
    String[] fecha;

    LayoutInflater inflater;

    public AdaptadorDetallePlanta(Context context, String[] accion, String[] observacion, String[] fecha) {
        this.context = context;
        this.accion = accion;
        this.observacion = observacion;
        this.fecha = fecha;
    }

    @Override
    public int getCount() {
        return accion.length;
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

        TextView accionObj = view.findViewById(R.id.accionID);
        TextView observacionObj = view.findViewById(R.id.observacionID);
        TextView fechaObj = view.findViewById(R.id.fechaID);

        accionObj.setText(accion[position]);
        observacionObj.setText(observacion[position]);
        fechaObj.setText(fecha[position]);
        return view;
    }
}
