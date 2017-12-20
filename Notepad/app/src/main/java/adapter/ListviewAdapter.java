package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.notepad.Notepad;
import com.example.administrator.notepad.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017-12-07.
 */

public class ListviewAdapter extends BaseAdapter {
    ArrayList<Notepad> items = new ArrayList<>();
    Context context;

    public ListviewAdapter(ArrayList<Notepad> items, Context context) {
        this.items = items;
        this.context = context;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();

        if(convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.notepad_listview, parent, false);
            holder.notepad_main_listview_title = convertView.findViewById(R.id.notepad_main_listview_title);

            convertView.setTag(holder);
        } else {
            holder = (Holder)convertView.getTag();
        }

        Notepad item = (Notepad)getItem(position);
        holder.notepad_main_listview_title.setText(item.getTitle());
        return convertView;
    }

    private class Holder {
        TextView notepad_main_listview_title;
    }
}
