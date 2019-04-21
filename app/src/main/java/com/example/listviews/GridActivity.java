package com.example.listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {

    private ArrayList<String> names ;
    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        gridView = (GridView) findViewById(R.id.gridView);

        names = new ArrayList<String>() {{
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
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridActivity.this, "Clicked: " + names.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        MyAdapter myAdapter = new MyAdapter(this,R.layout.grid_item,names);
        gridView.setAdapter(myAdapter);
    }
}
