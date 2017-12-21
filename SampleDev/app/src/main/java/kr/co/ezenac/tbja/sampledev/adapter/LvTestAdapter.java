package kr.co.ezenac.tbja.sampledev.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import kr.co.ezenac.tbja.sampledev.R;
import kr.co.ezenac.tbja.sampledev.model.Friend;

/**
 * Created by Administrator on 2017-11-21.
 */

public class LvTestAdapter extends BaseAdapter {
    ArrayList<Friend> items = new ArrayList<>();
    Context context;

    public LvTestAdapter(ArrayList<Friend> friends, Context context) {
        this.items = friends;
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
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
                    inflate(R.layout.item_test, viewGroup, false);
            holder.text_name = view.findViewById(R.id.text_name);
            holder.text_phone = view.findViewById(R.id.text_phone);
            holder.img_gender = view.findViewById(R.id.img_gender);

            view.setTag(holder);
        } else {
            holder = (Holder)view.getTag();
        }

        //String tmpName = (String) getItem(i);
        Friend item = (Friend) getItem(i);
        holder.text_name.setText(item.getName());
        holder.text_phone.setText(item.getPhone());

        //남자이면
        if (item.getGender() == 0) {
            holder.img_gender.setBackgroundResource(R.drawable.shape_female);
        } else {
            holder.img_gender.setBackgroundResource(R.drawable.shape_male);
        }

        return view;
    }
    private class Holder {
        TextView text_name;
        TextView text_phone;
        ImageView img_gender;
    }
}
