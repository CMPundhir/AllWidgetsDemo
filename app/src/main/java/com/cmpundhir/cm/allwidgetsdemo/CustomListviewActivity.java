package com.cmpundhir.cm.allwidgetsdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class CustomListviewActivity extends AppCompatActivity {
    String[] titles = {"Pizaa","Burger","Pasta","Dosa","Momos","Pizaa","Burger","Pasta","Dosa","Momos","Pizaa","Burger","Pasta","Dosa","Momos"};
    String[] prices = {"Rs. 600","Rs. 140","Rs. 150","Rs. 120","Rs. 130","Rs. 600","Rs. 140","Rs. 150","Rs. 120","Rs. 130","Rs. 600","Rs. 140","Rs. 150","Rs. 120","Rs. 130"};
    int[] imgs = {R.drawable.pizza,R.drawable.burger,R.drawable.pasta,R.drawable.dosa,R.drawable.momos,R.drawable.pizza,R.drawable.burger,R.drawable.pasta,R.drawable.dosa,R.drawable.momos,R.drawable.pizza,R.drawable.burger,R.drawable.pasta,R.drawable.dosa,R.drawable.momos};
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_listview);

        listView = findViewById(R.id.listview);
        MyAdapter adapter = new MyAdapter(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(CustomListviewActivity.this, i+"", Toast.LENGTH_SHORT).show();
            }
        });
    }

    class MyAdapter extends ArrayAdapter<String>{

        public MyAdapter(@NonNull Context context) {
            super(context,R.layout.food_item,titles);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.food_item,parent,false);
            TextView title,price;
            ImageView img;
            title = view.findViewById(R.id.title);
            price = view.findViewById(R.id.price);
            img = view.findViewById(R.id.imageView);

            title.setText(titles[position]);
            price.setText(prices[position]);
            img.setImageDrawable(getDrawable(imgs[position]));
            return view;
        }
    }
}
