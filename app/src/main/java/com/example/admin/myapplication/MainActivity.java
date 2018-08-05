package com.example.admin.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (double s = 0; s < 1; s = s + 0.1) {
            Log.d("sss",
                    Math.pow(1 - s, 3) * 50 + 3 * Math.pow(1 - s, 2) * s * 300 + 3 * Math.pow(1 - s,
                            2) * 100 + Math.pow(s, 3) * 400 + "");
        }
        //        RecyclerView recyclerView = findViewById(R.id.recycler_calendar);
        //        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //        recyclerView.setAdapter(new Adapter());
    }
}
