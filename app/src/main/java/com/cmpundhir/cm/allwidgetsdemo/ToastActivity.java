package com.cmpundhir.cm.allwidgetsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class ToastActivity extends AppCompatActivity {
    Button simpletoastBtn;
    ImageButton imageButton;
    private void init(){
        simpletoastBtn = findViewById(R.id.button);
        imageButton = findViewById(R.id.imageButton);
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
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPokeToast();
            }
        });
    }
    private void showPokeToast(){
        View layout = getLayoutInflater().inflate(R.layout.pokemon_toast,(ViewGroup) findViewById(R.id.custom_toast_layout));
        ImageView img = layout.findViewById(R.id.img);
        //int randomNum = ((int) (Math.random()*10))%6;
        Random random = new Random();
        int num = random.nextInt(6);
        switch (num){
            case 0 : img.setImageDrawable(getDrawable(R.drawable.balbasor));break;
            case 1 : img.setImageDrawable(getDrawable(R.drawable.pokemons));break;
            case 2 : img.setImageDrawable(getDrawable(R.drawable.squantel));break;
            case 3 : img.setImageDrawable(getDrawable(R.drawable.charmender));break;
            case 4 : img.setImageDrawable(getDrawable(R.drawable.psynduck));break;
            case 5 : img.setImageDrawable(getDrawable(R.drawable.balbasor));break;
            case 6 : img.setImageDrawable(getDrawable(R.drawable.sevouper));break;
            case 7 : img.setImageDrawable(getDrawable(R.drawable.squantel));break;
            case 8 : img.setImageDrawable(getDrawable(R.drawable.sevouper));break;
            case 9 : img.setImageDrawable(getDrawable(R.drawable.pokemons));break;
        }
        Log.d("random_num","num : "+num);
        Toast toast = new Toast(ToastActivity.this);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.setView(layout);
        toast.show();
    }
}
