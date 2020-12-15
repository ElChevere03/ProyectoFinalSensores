package com.example.proyecto2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class OptionsActivity extends AppCompatActivity {

    RadioButton radio1, radio2, radio3;
    MaterialButton seleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        radio1 = (RadioButton) findViewById(R.id.Radio1);
        radio2 = (RadioButton) findViewById(R.id.Radio2);
        radio3 = (RadioButton) findViewById(R.id.Radio3);
        seleccion = (MaterialButton) findViewById(R.id.seleccion);

        seleccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (radio1.isChecked())
                {
                    next(view, 1);
                }
                else if (radio2.isChecked())
                {
                    next(view, 2);
                }
                else if (radio3.isChecked())
                {
                    next(view,3);
                }

            }
        });

    }
    public void next(View view, int flag)
    {
        if (flag == 1)
        {
            Intent intent = new Intent(OptionsActivity.this, Option1Activity.class);
            startActivity(intent);
        }
        else if (flag == 2)
        {
            Intent intent = new Intent(OptionsActivity.this, Option2Activity.class);
            startActivity(intent);
        }
        else if (flag == 3)
        {
            Intent intent = new Intent(OptionsActivity.this, Option3Activity.class);
            startActivity(intent);
        }
    }

}


