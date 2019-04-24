package com.example.myapplicationxxx;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private PersonViewModel personVModel;
    private TextView textView ;
    private Button button;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textId);
        addButton = (Button) findViewById(R.id.buttonAdd);
       personVModel = ViewModelProviders.of(this).get(PersonViewModel.class);
        suscribeUiPersons();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                personVModel.AddAnother();
            }
        });
    }

    private void suscribeUiPersons() {
        personVModel.persons.observe(this, new Observer<List<Person>>() {
            @Override
            public void onChanged(@Nullable List<Person> people) {
                showPersonsInUI(people);
            }
        });
    }

    private void showPersonsInUI(@NonNull  List<Person> persons) {
        StringBuilder strB = new StringBuilder();
        for (Person person : persons){
            strB.append(person.getId());
            strB.append("\n");
            strB.append(person.getName());
            strB.append("\n");
        }
        textView.setText(strB);
    }



}
