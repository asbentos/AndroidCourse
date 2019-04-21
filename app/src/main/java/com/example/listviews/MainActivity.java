package com.example.listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);

        List<String> names = new ArrayList<String>() {{
            add("Andres");
            add("Mateo");
            add("Germán");
        }};
        for (int i=0;i<100; i++){
            names.add("Nombre"+i);
        }
        // Usamos un adaptador para el list view
        // Se neceita para renderizar.
        // Se le pasa un layout
        // Vamos a usar el básico de Android.
        // Si tengo mi layout se lo paso en el creador de adapter (personalizado)
        // La forma en que se visualizarán los datos.
        // Tal vez sea neesario pasarle mas cosas (un objeto más complejo en lugar de
        // pasarle String.
        ArrayAdapter<String> adapter  = new ArrayAdapter<String>
                    (this,android.R.layout.simple_list_item_1,names);
        //
        // Vinculamos el adaptador a nuestro listview
        listView.setAdapter(adapter);
    }
}
