package kr.co.ezenac.tbja.sampledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import kr.co.ezenac.tbja.sampledev.adapter.LvTestAdapter;
import kr.co.ezenac.tbja.sampledev.model.Friend;

public class Listview2Activity extends AppCompatActivity {
    ArrayList<Friend> friends = new ArrayList<>();
    ListView lv_test;
    LvTestAdapter lvTestAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview2);
        lv_test = findViewById(R.id.lv_test);

        for (int i = 0 ; i < 100 ; i++) {
            Friend friend = new Friend("kimseongjae_" + i,"010554545" + i,
                    (int)(Math.random()*2));
            friends.add(friend);
        }

        lvTestAdapter = new LvTestAdapter(friends,Listview2Activity.this);
        lv_test.setAdapter(lvTestAdapter);
    }
}
