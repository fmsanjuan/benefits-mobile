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


public class MealDetailsActivity extends ListActivity {

    private List<Amount> amountList = new ArrayList<Amount>();

    private Button backToMeal;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_details);

        Meal meal = (Meal) getIntent().getExtras().get("meal");
        amountList.addAll(meal.getAmounts());

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position,
                                    long id) {

            };
        });
        Vector<Amount> amountListToIndex = new Vector<Amount>(amountList);
        setListAdapter(new AdapterAmountList(MealDetailsActivity.this, amountListToIndex));

        backToMeal = (Button) findViewById(R.id.backToMealsFromAmounts);
        backToMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

}
