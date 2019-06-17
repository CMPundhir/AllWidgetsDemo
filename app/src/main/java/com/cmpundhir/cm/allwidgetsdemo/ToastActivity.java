package com.cmpundhir.cm.allwidgetsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {
    Button simpletoastBtn;
    private void init(){
        simpletoastBtn = findViewById(R.id.button);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        init();
        simpletoastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ToastActivity.this, "Simple toast", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
