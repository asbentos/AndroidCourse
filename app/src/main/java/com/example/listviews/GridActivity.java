package com.example.listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {

    private ArrayList<String> names ;
    private GridView gridView;
    private int counter =0;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        gridView = (GridView) findViewById(R.id.gridView);

        names = new ArrayList<String>() {{
            add("Nombrex1");
            add("Nombrex2");
            add("Nombrex3");

        }};
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridActivity.this, "Clicked: " + names.get(position), Toast.LENGTH_SHORT).show();
            }
        });

         myAdapter = new MyAdapter(this,R.layout.grid_item,names);
        gridView.setAdapter(myAdapter);
        registerForContextMenu(gridView);
    }
    //Inflamos el menu de opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu,menu);
        return true;
    }
    //Manejamos evento clic en el MEnu de opciones.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                //Añadimos un nuevo nobmre a la lista
                this.names.add("Added number: "+ (++counter ));
                //Notificamos al adaptador
                this.myAdapter.notifyDataSetChanged();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //Inflamos el layout del context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle("Se borró: "+ names.get(info.position));
        inflater.inflate(R.menu.context_menu,menu);
    }
    //Manejamos eventos click del context menu.
    @Override
    public boolean onContextItemSelected(MenuItem item){

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()){
            case (R.id.deleted_item):
                //Borramos item cliqueado , viene dada la posición del mismo
                this.names.remove(info.position);
                //Notificamos al adaptador
                this.myAdapter.notifyDataSetChanged();

                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
