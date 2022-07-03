package com.example.careshare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class Personal_Info extends AppCompatActivity {

    Spinner countryCode ;
    EditText phoneNumber ;
    String[] codes = {"+91" , "+92" , "+93" , "+94" , "+95" , "+96" , "+97" , "+98" , "+99"};

    public void helpAndSupport(View view){
        startActivity(new Intent(this , HelpAndSupport.class));
    }
    public void register(View view){

        startActivity(new Intent(this , verificationCode.class));
        phoneNumber = findViewById(R.id.phoneNumber);

        }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);

//        declare variables
        countryCode = findViewById(R.id.countryCode);
        phoneNumber = findViewById(R.id.phoneNumber);

        //drop down list
        ArrayAdapter<String> codeList = new ArrayAdapter<>(Personal_Info.this , android.R.layout.simple_spinner_item , codes);
        codeList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countryCode.setAdapter(codeList);

        countryCode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                String select = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }




}