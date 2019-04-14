package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import org.w3c.dom.Text;

import java.security.acl.Group;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private View btn;
    private final String  GREETER = "Hello from another acti";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById((R.id.buttonMain));

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //Acceder al segundo activity
                //y mandarle un string
                //desde donde estamos a donde vamos le debemos indicar
                //nuestro contexto a la clase adonde qquiero ir

                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                //le digo que quiero pasar y con que nomcre (Clave,Valor tipo primitivos y algunos mas)
                intent.putExtra("greeter",GREETER);
                //activo el Activity
                startActivity(intent);
            }
        });




    }


}
