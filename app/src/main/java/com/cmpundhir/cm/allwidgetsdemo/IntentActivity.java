package com.cmpundhir.cm.allwidgetsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cmpundhir.cm.allwidgetsdemo.intent_pckg.Next1Activity;

public class IntentActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2,b5,b6;

    private void init(){
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        init();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.b1:
                Intent intent = new Intent(IntentActivity.this, Next1Activity.class);
                intent.putExtra("pubg","CHicken Dinner");
                startActivity(intent);
                break;
            case R.id.b5:
                // Create the text message with a string
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Hamka kuchh nhi aataa");
                sendIntent.setType("text/plain");

                // Verify that the intent will resolve to an activity
                if (sendIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(sendIntent);
                }break;
        }
    }
}
