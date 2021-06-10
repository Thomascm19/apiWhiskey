package com.example.apiwhiskey.distillery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.apiwhiskey.R;

public class DistilleryItemActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_login_distillery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distillery_item);
        setView();
    }

    public void setView() {
        btn_login_distillery = findViewById(R.id.distilleryTextView);
        btn_login_distillery.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.distilleryTextView) {

        }
    }
}