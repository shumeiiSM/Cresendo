package com.example.a17010233.cresendo;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Level extends AppCompatActivity {

    Button play;
    Button back, sound;

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        play = findViewById(R.id.btnOrder);
        back = findViewById(R.id.back);
        sound = findViewById(R.id.sound);

        final MediaPlayer van = MediaPlayer.create(getApplicationContext(), R.raw.vanessa);

        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                van.start();
            }
        });

        models = new ArrayList<>();
        models.add(new Model(R.drawable.green, "Easy", "The level of Easy."));
        models.add(new Model(R.drawable.blue, "Intermediate", "The level of Intermediate."));
        models.add(new Model(R.drawable.red, "Advance", "The level of Advance."));
        models.add(new Model(R.drawable.black, "Insane", "The level of Insane."));

        adapter = new Adapter(models, this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4)
        };

        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (adapter.getCount() -1) && position < (colors.length -1)) {
                    viewPager.setBackgroundColor(
                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            ));
                } else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewPager.getCurrentItem() == 0) {
                    Intent intent = new Intent(getBaseContext(), Quiz.class);
                    startActivityForResult(intent, REQUEST_CODE);
                } else if (viewPager.getCurrentItem() == 1) {
                    Intent intent = new Intent(getBaseContext(), Intermediate.class);
                    startActivity(intent);
                } else if (viewPager.getCurrentItem() == 2) {
                    Intent intent = new Intent(getBaseContext(), Advance.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getBaseContext(), Insance.class);
                    startActivity(intent);
                }

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
