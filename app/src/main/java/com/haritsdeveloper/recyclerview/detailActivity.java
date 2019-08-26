package com.haritsdeveloper.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class detailActivity extends AppCompatActivity {

    public static final String KEY_MOVIE = "KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String idDetail = getIntent().getStringExtra(KEY_MOVIE);
        Toast.makeText(this,idDetail,Toast.LENGTH_SHORT).show();
    }
}
