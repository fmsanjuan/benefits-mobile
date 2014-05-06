package com.benefits.app;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Vector;

/**
 * Created by Jesus on 06/05/2014.
 */
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
        textView.setText(mealList.elementAt(position).getName().toString());
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
