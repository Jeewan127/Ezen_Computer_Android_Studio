package kr.co.ezenac.tbja.sampledev.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import kr.co.ezenac.tbja.sampledev.R;

/**
 * Created by Administrator on 2017-11-20.
 */

public class ListviewAdapter extends BaseAdapter {
    ArrayList<String> items = new ArrayList<>();

    public ListviewAdapter(ArrayList<String> items) {
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
        view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_layout, viewGroup, false);

        TextView text_fri = view.findViewById(R.id.text_fri);
        String name = (String) getItem(i);
        text_fri.setText(name);

        return view;
    }
}
