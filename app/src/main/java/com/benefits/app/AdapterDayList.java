package com.benefits.app;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Vector;

/**
 * Created by Jesus on 06/05/2014.
 */
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
        textView.setText(dayList.elementAt(position).getName().toString());
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
