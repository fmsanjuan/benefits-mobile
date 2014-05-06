package com.benefits.app;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class DayDetailsActivity extends ListActivity {

    private List<Meal> mealList = new ArrayList<Meal>();

    private Button backToDay;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_details);

        Day day = (Day) getIntent().getExtras().get("day");
        mealList.addAll(day.getMeals());

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position,
                                    long id) {

                Meal entry = (Meal) parent.getItemAtPosition(position);
                Intent i = new Intent(DayDetailsActivity.this,
                        MealDetailsActivity.class);
                i.putExtra("meal", entry);
                startActivity(i);

            };
        });
        Vector<Meal> mealListToIndex = new Vector<Meal>(mealList);
        setListAdapter(new AdapterMealList(DayDetailsActivity.this, mealListToIndex));

        backToDay = (Button) findViewById(R.id.backToDaysFromMeals);
        backToDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

}
