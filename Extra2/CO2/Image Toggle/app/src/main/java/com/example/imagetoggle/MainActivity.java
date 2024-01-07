package com.example.imagetoggle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img1, img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1=(ImageView) findViewById(R.id.img1);
        img2=(ImageView) findViewById(R.id.img2);
        img1.setOnClickListener(this::Clik);
        img2.setOnClickListener(this::Clik);

    }

    private void Clik(View view) {

        if(view.getId()==R.id.img1)
        {
            img1.setVisibility(view.GONE);
            img2.setVisibility(view.VISIBLE);
        }
        else if (view.getId()==R.id.img2)
        {
            img1.setVisibility(view.VISIBLE);
            img2.setVisibility(view.GONE);
        }
    }

}