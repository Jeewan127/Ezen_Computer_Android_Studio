package com.example.administrator.project01.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.project01.DetailsActivity;
import com.example.administrator.project01.Housekeep;
import com.example.administrator.project01.MainActivity;
import com.example.administrator.project01.R;
import com.example.administrator.project01.db.DBManager;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017-11-21.
 */

public class MainViewAdapter extends BaseAdapter {

    ArrayList<Housekeep> items = new ArrayList<>();
    Context context;
    DBManager dbManager;

    public MainViewAdapter(Context context, ArrayList<Housekeep> housekeeps, DBManager dbManager) {
        this.context = context;
        this.items = housekeeps;
        this.dbManager = dbManager;
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

        if(item.getType() == 0) {
            holder.main_textview2.setText("지출");
            holder.main_img_oval.setBackgroundResource(R.drawable.oval_pink);
        } else {
            holder.main_textview2.setText("입금");
            holder.main_img_oval.setBackgroundResource(R.drawable.oval_blue);
        }

        holder.main_textview1.setText(item.getCost().toString());

        final int tmpI = position;
        final int id = item.getId();
        holder.main_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context); // 생성자에 contexte가 있고 메인에서 생성해주면서 메인을 받아오기 때문에 context로 사용
                alertDialog.setTitle("삭제");
                alertDialog.setMessage("정말 삭제 하시겠습니까?");

                alertDialog.setPositiveButton("네", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        items.remove(tmpI);
                        dbManager.deleteData(id);
                        notifyDataSetChanged();
                    }
                });
                alertDialog.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                alertDialog.show();
            }
        });
        return convertView;
    }

    private class Holder {
        TextView main_textview1;
        TextView main_textview2;
        ImageView main_img_oval;
        ImageView main_delete;
    }
}
