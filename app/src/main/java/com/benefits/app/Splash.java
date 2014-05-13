package com.benefits.app;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;


public class Splash extends Activity {
	private long splashDelay = 3000; //3 segundos
	private ImageView imagenLogo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imagenLogo = (ImageView) findViewById(R.id.imageLogo);

        imagenLogo.setImageResource(R.drawable.ic_launcher);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent mainIntent = new Intent().setClass(Splash.this, LoginActivity.class);
                startActivity(mainIntent);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, splashDelay);//Pasado los 3 segundos dispara la tarea
    }

}