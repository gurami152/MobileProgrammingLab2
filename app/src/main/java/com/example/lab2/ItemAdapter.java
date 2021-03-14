package com.example.lab2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Item> items;
    public ItemAdapter(Context context, ArrayList<Item> items){
        this.context = context;this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_layout_item,parent,false);
        }
        Item currentItem = (Item) getItem(position);
        TextView textViewItemName = (TextView)convertView.findViewById(R.id.item_name);
        textViewItemName.setText(currentItem.itemName);
        TextView textViewItemClassification = (TextView)convertView.findViewById(R.id.item_group);
        textViewItemClassification.setText(currentItem.itemClassification);
        return convertView;
    }
}
