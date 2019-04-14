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

import org.w3c.dom.Text;

import java.security.acl.Group;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Button btnDoOperation;
    private EditText editTextFirstOperand;
    private EditText editTextSecondOperand;
    private TextView textViewOperationResult;
    private RadioGroup radioGroupOperations;
    private RadioButton radioButtonOperationSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDoOperation = (Button) findViewById(R.id.buttonDoOperation);
        btnDoOperation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextFirstOperand = (EditText) findViewById(R.id.editText4);
                editTextSecondOperand = (EditText) findViewById(R.id.editText5);
                textViewOperationResult = (TextView) findViewById(R.id.textView4);
                radioGroupOperations = (RadioGroup) findViewById(R.id.operationGroup);
                int radioButtonId = radioGroupOperations.getCheckedRadioButtonId();
                String operation = getResources().getResourceEntryName(radioButtonId);
                double first = Double.parseDouble(editTextFirstOperand.getText().toString());
                double second = Double.parseDouble((editTextSecondOperand.getText().toString()));
                double result=0;
                switch (operation){
                    case "radioButtonPlus":
                        result = first + second;
                        break;
                    case "radioButtonMinus":
                        result = first - second;
                        break;
                    case "radioButtonDivision":
                        if (second==0){
                            Toast errorMessage = Toast.makeText(getApplicationContext(),"No es posible dividir entre cero",Toast.LENGTH_LONG);
                           // errorMessage.setMargin(50,50);
                            errorMessage.show();
                        }
                        else{
                            result = first/second;
                        }
                        break;
                    case "radioButtonTimes":
                        result = first*second;
                        break;
                    default:
                        break;


                }
                textViewOperationResult.setText(String.valueOf(result));

            }


        });


    }


}
