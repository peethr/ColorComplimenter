package com.example.peethr.colorcomplimenter.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.peethr.colorcomplimenter.Model.Validate;
import com.example.peethr.colorcomplimenter.R;

public class MainActivity extends AppCompatActivity {

    private Button dalejButton;
    private EditText editText;

    private String color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        dalejButton = findViewById(R.id.dalejButton);

        dalejButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                color = editText.getText().toString();

                Validate validate = new Validate();
                color = validate.toLowerCase(color);

                if(validate.ifValid(color)){
                    Intent intent = new Intent(MainActivity.this, ShowColor.class);
                    intent.putExtra("Color", color);
                    startActivity(intent);

                } else {
                    Toast.makeText(MainActivity.this, "Invalid color", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
