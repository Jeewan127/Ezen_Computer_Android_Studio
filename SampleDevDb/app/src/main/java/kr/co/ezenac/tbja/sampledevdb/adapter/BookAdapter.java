package kr.co.ezenac.tbja.sampledevdb.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import kr.co.ezenac.tbja.sampledevdb.R;
import kr.co.ezenac.tbja.sampledevdb.model.Book;

/**
 * Created by Administrator on 2017-11-27.
 */

public class BookAdapter extends BaseAdapter {
    ArrayList<Book> items = new ArrayList<>();

    public BookAdapter(ArrayList<Book> items) {
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
                    inflate(R.layout.item_book, viewGroup, false);
            holder.txt_id = view.findViewById(R.id.txt_id);
            holder.txt_name = view.findViewById(R.id.txt_name);
            holder.txt_price = view.findViewById(R.id.txt_price);

            view.setTag(holder);
        } else {
            holder = (Holder)view.getTag();
        }

        Book item = (Book) getItem(i);
        holder.txt_id.setText(item.getId().toString());
        holder.txt_name.setText(item.getName());
        holder.txt_price.setText(item.getPrice().toString());

        return view;
    }

    private class Holder {
        TextView txt_id;
        TextView txt_name;
        TextView txt_price;
    }
}
