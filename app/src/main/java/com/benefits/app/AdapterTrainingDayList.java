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
        if(trainingDayList.elementAt(position).getName().toString().equals("MONDAY")){
            textView.setText(R.string.Monday);
        }
        if(trainingDayList.elementAt(position).getName().toString().equals("TUESDAY")){
            textView.setText(R.string.Tuesday);
        }
        if(trainingDayList.elementAt(position).getName().toString().equals("WEDNESDAY")){
            textView.setText(R.string.Wednesday);
        }
        if(trainingDayList.elementAt(position).getName().toString().equals("THURSDAY")){
            textView.setText(R.string.Thursday);
        }
        if(trainingDayList.elementAt(position).getName().toString().equals("FRIDAY")){
            textView.setText(R.string.Friday);
        }
        if(trainingDayList.elementAt(position).getName().toString().equals("SATURDAY")){
            textView.setText(R.string.Saturday);
        }
        if(trainingDayList.elementAt(position).getName().toString().equals("SUNDAY")){
            textView.setText(R.string.Sunday);
        }
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
