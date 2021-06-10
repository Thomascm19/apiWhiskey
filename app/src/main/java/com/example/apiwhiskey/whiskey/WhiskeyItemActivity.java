package com.example.apiwhiskey.whiskey;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.apiwhiskey.R;

public class WhiskeyItemActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_item_whiskey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setView();
    }

    public void setView() {
        btn_item_whiskey = findViewById(R.id.whiskeyTextView);
        btn_item_whiskey.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.whiskeyTextView) {
            Log.e("Test", "Distillery: ");
        }
    }
}

