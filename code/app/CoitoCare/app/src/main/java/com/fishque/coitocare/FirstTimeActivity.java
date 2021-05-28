package com.fishque.coitocare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.fishque.coitocare.FirstTimeMainFragment;

public class FirstTimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_time);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, FirstTimeMainFragment.newInstance("1", "2"))
                    .commitNow();
        }
    }
}