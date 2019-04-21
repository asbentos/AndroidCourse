package com.example.listviews;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> names;

    public MyAdapter(Context context, int layout, List<String> names){

        this.context = context;
        this.layout  = layout;
        this.names   = names;
    }

    @Override
    public int getCount() {


        return this.names.size();
    }

    @Override
    public Object getItem(int position) {

        return this.names.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ViewHolder holder;

        if (convertView == null){
            //Inflamos la vista uqe ha llegado con nuestro
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(R.layout.list_item,null);
            holder = new ViewHolder();

            //Referenciamos al elemento a agregar y lo rellanamos
            holder.nameTextView = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        //valor , lo traemos, según la posición de la lista seleccionada
        String currentElement = names.get(position);
        holder.nameTextView.setText(currentElement);
        return  convertView;


    }
    //Una especie de Wrapper - ViewHolder Pattern
    private  static  class  ViewHolder{
        private  TextView nameTextView;
        //Si hubiera más elementos a manipular los creeo aquí.
    }
}
