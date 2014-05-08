package com.benefits.app;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class TrainingActivity extends ListActivity {

    private List<TrainingDay> trainingDayList = new ArrayList<TrainingDay>();

    private Button back;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        Training training = (Training) getIntent().getExtras().get("training");
        trainingDayList.addAll(training.getTrainingDays());

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position,
                                    long id) {

                TrainingDay entry = (TrainingDay) parent.getItemAtPosition(position);
                Intent i = new Intent(TrainingActivity.this,
                        TrainingDayDetailsActivity.class);
                i.putExtra("trainingDay", entry);
                startActivity(i);

            };
        });
        Vector<TrainingDay> trainingDayListToIndex = new Vector<TrainingDay>(trainingDayList);
        setListAdapter(new AdapterTrainingDayList(TrainingActivity.this, trainingDayListToIndex));

        back = (Button) findViewById(R.id.backToSelectFromTraining);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

}
