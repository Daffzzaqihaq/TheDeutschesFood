package com.daffzzaqihaq.thedeutschesfood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {

    private long ms = 0;
    private long SplashTime = 3000;
    private boolean SplashActive = true;
    private boolean Paused = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        findViewById(R.id.progresbar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final ProgressBar progressBar = findViewById(R.id.progresbar);

        Thread mythread = new Thread() {
            public void run() {
                try {
                    while (SplashActive && ms <SplashTime) {
                        if(!Paused) {
                            ms = ms + 50;
                            sleep(50);
                            progressBar.setProgress((int)ms);
                        }
                    }

                }catch (Exception e) {
                }finally {
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        mythread.start();
    }
}
