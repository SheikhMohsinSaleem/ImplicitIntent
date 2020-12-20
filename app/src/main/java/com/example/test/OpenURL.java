package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URI;

public class OpenURL extends AppCompatActivity {

    private EditText input;
    private Button load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_u_r_l);

        input = findViewById(R.id.input);
        load = findViewById(R.id.button);

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = input.getText().toString();

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                Intent chooser = Intent.createChooser(intent,"Choose an application");
                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(chooser);
                }

            }
        });
    }
}