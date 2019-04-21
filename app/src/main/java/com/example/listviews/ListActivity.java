package com.example.listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    List<TheElement> names = new ArrayList<TheElement>() {{

        add(new TheElement("Pep",   "000000"));
        add(new TheElement("Andres","111111"));
        add(new TheElement("Mateo", "222222"));
        add(new TheElement("German","333333"));
        add(new TheElement("Jorge", "444444"));

    }};

    private ListView listView;
    ArrayList<String> namesStr = new ArrayList<String>() {{
        add("Nombrex1");
        add("Nombrex2");
        add("Nombrex3");
        add("Nombrey1");
        add("Nombrey2");
        add("Nombrey3");
        add("Nombrez1");
        add("Nombrez2");
        add("Nombrez3");
        add("NombreAx1");
        add("NombreAx2");
        add("NombreAx3");
        add("NombreAy1");
        add("NombreAy2");
        add("NombreAy3");
        add("NombreAz1");
        add("NombreAz2");
        add("NombreAz3");
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        // Usamos un adaptador para el list view
        // Se neceita para renderizar.
        // Se le pasa un layout
        // Vamos a usar el básico de Android.
        // Si tengo mi layout se lo paso en el creador de adapter (personalizado)
        // La forma en que se visualizarán los datos.
        // Tal vez sea neesario pasarle mas cosas (un objeto más complejo en lugar de
        // pasarle String.
       // ArrayAdapter<TheElement> adapter = new ArrayAdapter<TheElement>
         //       (this, android.R.layout.simple_list_item_1, namesStr);
        //
        // Vinculamos el adaptador a nuestro listview
       // listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), namesStr.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        //Enlazar con nuestro adaptador personalizado

        MyAdapter myAdapter = new MyAdapter(this, R.layout.list_item, namesStr);
        listView.setAdapter(myAdapter);
    }
}

