package com.benefits.app;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Vector;

public class AdapterDayList extends BaseAdapter {
    private final Activity activity;
    private final Vector<Day> dayList;

    public AdapterDayList(Activity activity, Vector<Day> dayList) {
        super();
        this.activity = activity;
        this.dayList = dayList;
    }

    public View getView(int position, View convertView,
                        ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.adapter_days, null,
                true);
        TextView textView =(TextView)view.findViewById(R.id.day);
        if(dayList.elementAt(position).getName().toString().equals("MONDAY")){
            textView.setText(R.string.Monday);
        }
        if(dayList.elementAt(position).getName().toString().equals("TUESDAY")){
            textView.setText(R.string.Tuesday);
        }
        if(dayList.elementAt(position).getName().toString().equals("WEDNESDAY")){
            textView.setText(R.string.Wednesday);
        }
        if(dayList.elementAt(position).getName().toString().equals("THURSDAY")){
            textView.setText(R.string.Thursday);
        }
        if(dayList.elementAt(position).getName().toString().equals("FRIDAY")){
            textView.setText(R.string.Friday);
        }
        if(dayList.elementAt(position).getName().toString().equals("SATURDAY")){
            textView.setText(R.string.Saturday);
        }
        if(dayList.elementAt(position).getName().toString().equals("SUNDAY")){
            textView.setText(R.string.Sunday);
        }
        return view;
    }

    public int getCount() {
        return dayList.size();
    }

    public Object getItem(int arg0) {
        return dayList.elementAt(arg0);
    }

    public long getItemId(int position) {
        return position;
    }
}
