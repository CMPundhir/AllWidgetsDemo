package com.cmpundhir.cm.allwidgetsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cmpundhir.cm.allwidgetsdemo.layouts_demos.ScrollVIewActivity;

public class LayoutsActivity extends AppCompatActivity implements View.OnClickListener {
    Button b10,b11,b12,b13;

    private void init(){
        b10 = findViewById(R.id.button10);
        b11 = findViewById(R.id.button11);
        b12 = findViewById(R.id.button12);
        b13 = findViewById(R.id.button13);
        b10.setOnClickListener(this);
        b11.setOnClickListener(this);
        b12.setOnClickListener(this);
        b13.setOnClickListener(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layouts);
        init();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Intent intent = null;
        switch (id){
            case R.id.button10:break;
            case R.id.button11:
                intent = new Intent(LayoutsActivity.this, ScrollVIewActivity.class);
                break;
            case R.id.button12:break;
            case R.id.button13:break;
        }
        if(intent!=null)
        startActivity(intent);
    }
}
