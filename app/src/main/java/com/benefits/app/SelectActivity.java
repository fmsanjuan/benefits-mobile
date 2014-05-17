package com.benefits.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class SelectActivity extends Activity {

    private Plan plan;
    private ImageView imageTraining, imageDiet;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        plan = (Plan) getIntent().getExtras().getSerializable("plan");
        imageTraining = (ImageView) findViewById(R.id.imageTraining);
        imageDiet = (ImageView) findViewById(R.id.imageDiet);

        imageTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(SelectActivity.this, "Training!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SelectActivity.this, TrainingActivity.class);
                intent.putExtra("training", plan.getTraining());
                startActivity(intent);
            }
        });

        imageDiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(SelectActivity.this, "Diet!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SelectActivity.this, DietActivity.class);
                intent.putExtra("diet", plan.getDiet());
                startActivity(intent);
            }
        });

        back = (Button) findViewById(R.id.quit);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


}
