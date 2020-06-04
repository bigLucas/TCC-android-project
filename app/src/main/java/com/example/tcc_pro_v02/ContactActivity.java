package com.example.tcc_pro_v02;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class ContactActivity extends AppCompatActivity {
    private int numEntrada = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle dados = getIntent().getExtras();
        assert dados != null;
        int actionCode = dados.getInt("actionCode");

        switch (actionCode) {
            case 1: {
                setContentView(R.layout.activity_new_contact);

                Button contatoNA = findViewById(R.id.button3);
                Button contatoNF = findViewById(R.id.button2);
                contatoNA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent result = new Intent();
                        result.putExtra("inputNumber", numEntrada);
                        result.putExtra("contactType", 1);
                        setResult(RESULT_OK, result);
                        finish();
                    }
                });
                contatoNF.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent result = new Intent();
                        result.putExtra("inputNumber", numEntrada);
                        result.putExtra("contactType", 2);
                        setResult(RESULT_OK, result);
                        finish();
                    }
                });
                break;
            }
            case 2: {
                setContentView(R.layout.activity_new_coil);

                Button bobinaNA = findViewById(R.id.button5);
                bobinaNA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent result = new Intent();
                        result.putExtra("outputNumber", numEntrada);
                        result.putExtra("contactType", 1);
                        setResult(RESULT_OK, result);
                        finish();
                    }
                });
                break;
            }
        }
    }

    public void onRadioButtonClicked(@NonNull View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton: {
                if (checked) {
                    numEntrada = 0;
                    break;
                }
            }
            case R.id.radioButton2: {
                if (checked) {
                    numEntrada = 1;
                    break;
                }
            }
            case R.id.radioButton3: {
                if (checked) {
                    numEntrada = 2;
                    break;
                }
            }
            case R.id.radioButton4: {
                if (checked) {
                    numEntrada = 3;
                    break;
                }
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
