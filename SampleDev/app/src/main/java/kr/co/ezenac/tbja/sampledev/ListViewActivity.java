package kr.co.ezenac.tbja.sampledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import kr.co.ezenac.tbja.sampledev.adapter.ListviewAdapter;

public class ListViewActivity extends AppCompatActivity {
    ListView lv_names;
    ListviewAdapter listviewAdapter;
    ArrayList<String> names = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        for (int i = 0 ; i < 100 ; i++) {
            names.add("kimseongjae_" + i);
        }

        listviewAdapter = new ListviewAdapter(names);
        lv_names = findViewById(R.id.lv_names);
        lv_names.setAdapter(listviewAdapter);
    }
}
