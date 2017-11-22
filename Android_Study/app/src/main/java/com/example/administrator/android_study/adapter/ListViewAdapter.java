package com.example.administrator.android_study.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.android_study.R;
import com.example.administrator.android_study.model.Friend;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017-11-20.
 */

public class ListViewAdapter extends BaseAdapter{
    ArrayList<Friend> items = new ArrayList<>();

    public ListViewAdapter(ArrayList<Friend> friends) {
        this.items = friends;
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
        // 1번째 파라미터: 아이템의 인덱스, 리스트뷰에서 보일 아이템의 위치 정보, 0부터 시작하여 아이템의 개수만큼 파라미터로 전달
        // 2번째 파라미터: 현재 인덱스의 해당하는 뷰 객체를 의미
        // 3번째 파라미터: 이 뷰를 포함고 있는 부모 컨테이너 객체

        // ListView를 쓰는 최적화 방법
        Holder holder = new Holder();

        if(view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).
                    inflate(R.layout.item_listview, viewGroup, false);
            holder.text_name = view.findViewById(R.id.text_name);
            holder.text_phone = view.findViewById(R.id.text_phone);
            holder.img_gender = view.findViewById(R.id.img_gender);

            view.setTag(holder); // Holder를 태그

        } else {
            holder = (Holder)view.getTag();
       }

        Friend item = (Friend) getItem(i);
        holder.text_name.setText(item.getName());
        holder.text_phone.setText(item.getPhone());

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
