package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    //aca tenemos recibir el valor del text view donde llenar.
    //el valor de lo que nos pasa
    //meterlo adentro del primero

    private TextView textView;
    private Button btnGoShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //Activar flecha ir atrás.
          //getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        textView = (TextView) findViewById(R.id.textViewMain);
        btnGoShare = (Button) findViewById(R.id.buttonGoSharing);
        //tomar los datos del intent
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null
                && (bundle.getString("greeter")!= null)) {
            //
            String greeter = bundle.getString("greeter");
            Toast.makeText(SecondActivity.this,greeter, Toast.LENGTH_LONG).show();
            textView.setText(greeter);
        }
        else {
            Toast.makeText(SecondActivity.this,"It is empty", Toast.LENGTH_LONG).show();
        }
        btnGoShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);

            }
        });
    }
}
