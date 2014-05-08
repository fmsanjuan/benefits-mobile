package com.benefits.app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Vector;


public class AdapterExerciseList extends BaseAdapter {
    private final Activity activity;
    private final Vector<Exercise> exercises;

    public AdapterExerciseList(Activity activity, Vector<Exercise> exercises) {
        super();
        this.activity = activity;
        this.exercises = exercises;
    }

    public View getView(int position, View convertView,
                        ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.adapter_exercise, null,
                true);
        ImageView imagePlay = (ImageView) view.findViewById(R.id.imagePlay);
        imagePlay.setImageResource(R.drawable.play);
        TextView exercise =(TextView)view.findViewById(R.id.exercise);
        exercise.setText(exercises.elementAt(position).getName());
        TextView description =(TextView)view.findViewById(R.id.descriptionExercise);
        description.setText(exercises.elementAt(position).getDescription());
        TextView cyclesrepetitions =(TextView)view.findViewById(R.id.cyclesrepetitions);
        cyclesrepetitions.setText("C: "+exercises.elementAt(position).getCycles().toString()
        + "  R: "+exercises.elementAt(position).getRepetitions().toString());
        return view;
    }

    public int getCount() {
        return exercises.size();
    }

    public Object getItem(int arg0) {
        return exercises.elementAt(arg0);
    }

    public long getItemId(int position) {
        return position;
    }

}
