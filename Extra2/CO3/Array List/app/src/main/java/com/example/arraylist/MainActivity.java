package com.example.arraylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    String carlist[]={"BMW","Audi","Porsche","Mercedes Benz"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview=(ListView) findViewById(R.id.listview);
        ArrayAdapter<String>arrayadapter=new ArrayAdapter<>(this,R.layout.items,R.id.tview,carlist);
        listview.setAdapter(arrayadapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clicked=parent.getItemAtPosition(position).toString();
                if(clicked=="Porsche")
                {
                    Intent intent=new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                }
                if(clicked=="BMW")
                {
                    Intent intent=new Intent(MainActivity.this, MainActivity4.class);
                    startActivity(intent);
                }
                if(clicked=="Mercedes Benz")
                {
                    Intent intent=new Intent(MainActivity.this, MainActivity5.class);
                    startActivity(intent);
                }
                if(clicked=="Audi")
                {
                    Intent intent=new Intent(MainActivity.this, MainActivity3.class);
                    startActivity(intent);
                }

            }
        });

    }
}