package com.benefits.app;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class ExerciseGroupDetailsActivity extends ListActivity {

    private List<Exercise> exerciseList = new ArrayList<Exercise>();

    private Button backToTrainingDay;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_group_details_activity);

        ExerciseGroup exerciseGroup = (ExerciseGroup) getIntent().getExtras().get("exerciseGroup");
        exerciseList.addAll(exerciseGroup.getExercises());


        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {

                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("https://www.youtube.com/watch?v="+exerciseList.get(position).getUrlYoutube()));
                startActivity(myWebLink);

            };
        });


        Vector<Exercise> exerciseListToIndex = new Vector<Exercise>(exerciseList);
        setListAdapter(new AdapterExerciseList(ExerciseGroupDetailsActivity.this, exerciseListToIndex));

        backToTrainingDay = (Button) findViewById(R.id.backToExerciseGroupFromExercise);
        backToTrainingDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

}
