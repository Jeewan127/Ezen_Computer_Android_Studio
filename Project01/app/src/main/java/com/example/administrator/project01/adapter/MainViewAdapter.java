package com.example.administrator.project01.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.project01.Housekeep;
import com.example.administrator.project01.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017-11-21.
 */

public class MainViewAdapter extends BaseAdapter {

    ArrayList<Housekeep> items = new ArrayList<>();

    public MainViewAdapter(ArrayList<Housekeep> housekeeps) {
        this.items = housekeeps;
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
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Holder holder = new Holder();

        if(convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.item_listview, parent, false);
            holder.main_textview1 = convertView.findViewById(R.id.main_textview1);
            holder.main_textview2 = convertView.findViewById(R.id.main_textview2);
            holder.main_img_oval = convertView.findViewById(R.id.main_img_oval);
            holder.main_delete = convertView.findViewById(R.id.main_delete);

            convertView.setTag(holder);
        } else {
            holder = (Holder)convertView.getTag();
        }

        Housekeep item = (Housekeep)getItem(position);
        holder.main_delete.setBackgroundResource(R.drawable.ic_edit_delete_keycolor);

        if(item.getType() == 0) {
            holder.main_textview2.setText("지출");
            holder.main_img_oval.setBackgroundResource(R.drawable.oval_pink);
        } else {
            holder.main_textview2.setText("입금");
            holder.main_img_oval.setBackgroundResource(R.drawable.oval_blue);
        }

        holder.main_textview1.setText(item.getCost().toString());

        holder.main_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.remove(position);
                notifyDataSetChanged();
            }
        });
        return convertView;
    }



    private class Holder {
        TextView main_textview1;
        TextView main_textview2;
        ImageView main_img_oval;
        Button main_delete;
    }
}
