package com.example.mainactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private ArrayList<com.example.mainactivity.Sport> list;
    private Context context;
    private int Resource;

    public MyAdapter(Context context, int resource, ArrayList list) {
        this.list = list;
        this.context = context;
        Resource = resource;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(Resource, null, false);
        }

        TextView sportName = view.findViewById(R.id.MainActivity_lv_sportName);
        TextView sportBestTime = view.findViewById(R.id.MainActivity_lv_sportBestTime);
        TextView sportInformation = view.findViewById(R.id.MainActivity_lv_sportInformation);
        ImageView sportImage = view.findViewById(R.id.MainActivity_lv_sportImage);

        String information = list.get(position).getInformation().substring(0, 70)+"...";

        sportName.setText(list.get(position).getName());
        sportBestTime.setText(list.get(position).getSportTime());
        sportInformation.setText(information);
        sportImage.setImageResource(list.get(position).getImagePath());

        return view;
    }


    public ArrayList getList() {
        return list;
    }

    public void setList(ArrayList list) {
        this.list = list;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getResource() {
        return Resource;
    }

    public void setResource(int resource) {
        Resource = resource;
    }
}
