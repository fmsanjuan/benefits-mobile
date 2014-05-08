package com.benefits.app;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Vector;


public class AdapterExerciseGroupList extends BaseAdapter {
    private final Activity activity;
    private final Vector<ExerciseGroup> exerciseGroupList;

    public AdapterExerciseGroupList(Activity activity, Vector<ExerciseGroup> exerciseGroupList) {
        super();
        this.activity = activity;
        this.exerciseGroupList = exerciseGroupList;
    }

    public View getView(int position, View convertView,
                        ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.adapter_meals, null,
                true);
        TextView textView =(TextView)view.findViewById(R.id.meal);
        textView.setText(exerciseGroupList.elementAt(position).getName().toString());
        return view;
    }

    public int getCount() {
        return exerciseGroupList.size();
    }

    public Object getItem(int arg0) {
        return exerciseGroupList.elementAt(arg0);
    }

    public long getItemId(int position) {
        return position;
    }
}
