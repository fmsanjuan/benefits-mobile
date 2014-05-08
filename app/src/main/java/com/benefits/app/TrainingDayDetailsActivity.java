package com.benefits.app;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class TrainingDayDetailsActivity extends ListActivity {

    private List<ExerciseGroup> exerciseGroupsList = new ArrayList<ExerciseGroup>();

    private Button backToTrainingDay;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_day_details);

        TrainingDay trainingDay = (TrainingDay) getIntent().getExtras().get("trainingDay");
        exerciseGroupsList.addAll(trainingDay.getExerciseGroups());

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position,
                                    long id) {

                ExerciseGroup entry = (ExerciseGroup) parent.getItemAtPosition(position);
                Intent i = new Intent(TrainingDayDetailsActivity.this,
                        ExerciseGroupDetailsActivity.class);
                i.putExtra("exerciseGroup", entry);
                startActivity(i);

            };
        });
        Vector<ExerciseGroup> exerciseGroupListToIndex = new Vector<ExerciseGroup>(exerciseGroupsList);
        setListAdapter(new AdapterExerciseGroupList(TrainingDayDetailsActivity.this, exerciseGroupListToIndex));

        backToTrainingDay = (Button) findViewById(R.id.backToTrainingDaysFromExerciseGroup);
        backToTrainingDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

}
