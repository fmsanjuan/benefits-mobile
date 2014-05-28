package com.benefits.app;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Vector;


public class AdapterMealList extends BaseAdapter {
    private final Activity activity;
    private final Vector<Meal> mealList;

    public AdapterMealList(Activity activity, Vector<Meal> mealList) {
        super();
        this.activity = activity;
        this.mealList = mealList;
    }

    public View getView(int position, View convertView,
                        ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.adapter_meals, null,
                true);
        TextView textView =(TextView)view.findViewById(R.id.meal);
        if(mealList.elementAt(position).getName().toString().equals("BREAKFAST")){
            textView.setText(R.string.Breakfast);
        }
        if(mealList.elementAt(position).getName().toString().equals("MID_MORNING")){
            textView.setText(R.string.MidMorning);
        }
        if(mealList.elementAt(position).getName().toString().equals("LUNCH")){
            textView.setText(R.string.Lunch);
        }
        if(mealList.elementAt(position).getName().toString().equals("TEA_TIME")){
            textView.setText(R.string.TeaTime);
        }
        if(mealList.elementAt(position).getName().toString().equals("DINNER")){
            textView.setText(R.string.Dinner);
        }
        return view;
    }

    public int getCount() {
        return mealList.size();
    }

    public Object getItem(int arg0) {
        return mealList.elementAt(arg0);
    }

    public long getItemId(int position) {
        return position;
    }
}
