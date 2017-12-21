package kr.co.ezenac.tbja.sampledev.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import kr.co.ezenac.tbja.sampledev.R;
import kr.co.ezenac.tbja.sampledev.model.GridItem;

/**
 * Created by Administrator on 2017-12-14.
 */

public class GridAdapter extends BaseAdapter {
    ArrayList<GridItem> items = new ArrayList<>();

    public GridAdapter(ArrayList<GridItem> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Object getItem(int i) {
        return this.items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder = new Holder();

        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).
                    inflate(R.layout.item_gridview, viewGroup, false);
            holder.text_color_name = view.findViewById(R.id.text_color_name);
            holder.img_back = view.findViewById(R.id.img_back);

            view.setTag(holder);
        } else {
            holder = (Holder)view.getTag();
        }

        GridItem item = this.items.get(i);
        holder.text_color_name.setText(item.getName());
        holder.img_back.setBackgroundColor(Color.parseColor(item.getColor()));

        return view;
    }

    private class Holder {
        TextView text_color_name;
        ImageView img_back;
    }
}
