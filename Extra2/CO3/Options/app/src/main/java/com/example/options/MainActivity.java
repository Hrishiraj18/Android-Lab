package com.example.options;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       MenuInflater inflater=getMenuInflater();
       inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Integer ids=item.getItemId();

        if(ids==R.id.item1)
        {
            Toast.makeText(this, "Item 1 invoked", Toast.LENGTH_SHORT).show();
        }
        if(ids==R.id.item2)
        {
            Toast.makeText(this, "Item 2 invoked", Toast.LENGTH_SHORT).show();
        }
        if(ids==R.id.item3)
        {
            Toast.makeText(this, "item 3 invoked", Toast.LENGTH_SHORT).show();

        }
        if(ids==R.id.image)
        {
            Intent intent=new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);

        }
        if(ids==R.id.share)
        {
            Intent intent=new Intent(MainActivity.this, MainActivity3.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}