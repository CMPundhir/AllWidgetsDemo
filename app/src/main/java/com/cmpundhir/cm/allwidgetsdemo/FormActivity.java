package com.cmpundhir.cm.allwidgetsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    Button btn;
    RadioGroup rg;
    TextView textView;
    CheckBox checkBox;
    private void init(){
        e1 = findViewById(R.id.editText);
        e2 = findViewById(R.id.editText2);
        e3 = findViewById(R.id.editText3);
        e4 = findViewById(R.id.editText4);
        btn = findViewById(R.id.button6);
        rg = findViewById(R.id.rg);
        checkBox = findViewById(R.id.checkBox);
        textView = findViewById(R.id.textView2);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        init();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox.isChecked()) {
                    String name, email, phone, gender, dob;
                    name = e1.getText().toString();
                    email = e2.getText().toString();
                    phone = e3.getText().toString();
                    dob = e4.getText().toString();
                    RadioButton rb = findViewById(rg.getCheckedRadioButtonId());
                    gender = rb.getText().toString();

                    StringBuffer buffer = new StringBuffer();
                    buffer.append("name : " + name + "\n");
                    buffer.append("email : " + email + "\n");
                    buffer.append("phone : " + phone + "\n");
                    buffer.append("dob : " + dob + "\n");
                    buffer.append("gender : " + gender + "\n");
                    textView.setText(buffer.toString());
                }else{
                    Toast.makeText(FormActivity.this, "Please accept terms and conditions", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
