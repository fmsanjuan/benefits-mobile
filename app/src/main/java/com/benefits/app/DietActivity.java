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


public class DietActivity extends ListActivity {

    private List<Day> daysList = new ArrayList<Day>();

    private Button back;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);

        Diet diet = (Diet) getIntent().getExtras().get("diet");
        daysList.addAll(diet.getDays());

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position,
                                    long id) {

                Day entry = (Day) parent.getItemAtPosition(position);
                Intent i = new Intent(DietActivity.this,
                        DayDetailsActivity.class);
                i.putExtra("day", entry);
                startActivity(i);

            };
        });
        Vector<Day> dayListToIndex = new Vector<Day>(daysList);
        setListAdapter(new AdapterDayList(DietActivity.this, dayListToIndex));

        back = (Button) findViewById(R.id.backToSelectFromDiet);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

}
