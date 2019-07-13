package com.example.moon.viewmodeldemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView textView;
    private static final String TAG = "MyTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.random_num);
        Log.d(TAG, "onCreate: ");
        final Data_Generator model = ViewModelProviders.of(this).get(Data_Generator.class);
        MutableLiveData mutableLiveData = model.getNumber();
        mutableLiveData.observe(this, new Observer() {
            @Override
            public void onChanged(Object o) {
                Log.d(TAG, "onChanged: UI Updated");
                textView.setText(String.valueOf(o));

            }
        });





        ((Button)findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.createLiveData();
            }
        });

    }
}
