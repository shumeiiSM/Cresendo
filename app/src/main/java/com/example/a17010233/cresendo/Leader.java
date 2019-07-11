package com.example.a17010233.cresendo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;


public class Leader extends AppCompatActivity {

    Button btnBack;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        viewPager = findViewById(R.id.container);
        tabLayout = findViewById(R.id.tabs);
        btnBack = findViewById(R.id.back);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        // Add Fragment
        adapter.addFrag(new EasyFragment(), "EASY");
        adapter.addFrag(new IntermediateFragment(), "INTER");
        adapter.addFrag(new AdvanceFragment(), "ADVANCE");
        adapter.addFrag(new InsaneFragment(), "INSANE");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

//        // Receive Easy
//        Intent eReceived = getIntent();
//        int escore = eReceived.getIntExtra("escore", 0);
//        String edate = eReceived.getStringExtra("edate");
//        String etime = eReceived.getStringExtra("etime");


//        EasyFragment myObj = new EasyFragment();
//        FragmentManager manager = getSupportFragmentManager();
//        FragmentTransaction t = manager.beginTransaction();
//
//        Bundle bundle = new Bundle();
//        bundle.putInt("escore", escore);
//        bundle.putString("edate", edate);
//        bundle.putString("etime", etime);
//
//        // set MyFragment Arguments
//        myObj.setArguments(bundle);
////        t.add(R.id.container, myObj);
//        t.replace(R.id.container,myObj);
//        t.commit();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);
            }
        });



    }
}
