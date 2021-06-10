package com.example.apiwhiskey;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apiwhiskey.distillery.DistilleryActivity;
import com.example.apiwhiskey.whiskey.WhiskeyActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_login_distillery;
    private Button btn_login_whiskey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setView();
    }

    public void setView() {
        btn_login_distillery = findViewById(R.id.button_login_distillery);
        btn_login_whiskey = findViewById(R.id.button_login_whiskey);
        btn_login_distillery.setOnClickListener(this);
        btn_login_whiskey.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_login_distillery) {
            Intent intent = new Intent(this, DistilleryActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.button_login_whiskey) {
            Intent intent = new Intent(this, WhiskeyActivity.class);
            startActivity(intent);
        }
    }
}