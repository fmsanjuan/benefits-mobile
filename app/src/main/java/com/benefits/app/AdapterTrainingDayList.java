package com.benefits.app;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Vector;


public class AdapterTrainingDayList extends BaseAdapter {
    private final Activity activity;
    private final Vector<TrainingDay> trainingDayList;

    public AdapterTrainingDayList(Activity activity, Vector<TrainingDay> dayList) {
        super();
        this.activity = activity;
        this.trainingDayList = dayList;
    }

    public View getView(int position, View convertView,
                        ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.adapter_days, null,
                true);
        TextView textView =(TextView)view.findViewById(R.id.day);
        textView.setText(trainingDayList.elementAt(position).getName().toString());
        return view;
    }

    public int getCount() {
        return trainingDayList.size();
    }

    public Object getItem(int arg0) {
        return trainingDayList.elementAt(arg0);
    }

    public long getItemId(int position) {
        return position;
    }
}
