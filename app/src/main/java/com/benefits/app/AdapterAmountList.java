package com.benefits.app;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Vector;


public class AdapterAmountList extends BaseAdapter {
    private final Activity activity;
    private final Vector<Amount> amounts;

    public AdapterAmountList(Activity activity, Vector<Amount> amounts) {
        super();
        this.activity = activity;
        this.amounts = amounts;
    }

    public View getView(int position, View convertView,
                        ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.adapter_amounts, null,
                true);
        ImageView imageFood = (ImageView) view.findViewById(R.id.imageFood);
        byte [] image = amounts.elementAt(position).getFood().getImage();
        Bitmap bmp = BitmapFactory.decodeByteArray(image, 0, image.length);
        imageFood.setImageBitmap(bmp);
        TextView food =(TextView)view.findViewById(R.id.food);
        food.setText(amounts.elementAt(position).getFood().getName());
        TextView description =(TextView)view.findViewById(R.id.descriptionFood);
        try {
            byte spbyte[] = amounts.elementAt(position).getFood().getDescription().getBytes("UTF-8");
            String str = new String( spbyte,"UTF-8");
            description.setText(str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        TextView quantityandmeasure =(TextView)view.findViewById(R.id.quantityandmeasure);
        try {
            quantityandmeasure.setText(amounts.elementAt(position).getQuantity()+" "+ URLEncoder.encode((amounts.elementAt(position).getMeasure()), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return view;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    public int getCount() {
        return amounts.size();
    }

    public Object getItem(int arg0) {
        return amounts.elementAt(arg0);
    }

    public long getItemId(int position) {
        return position;
    }
}
