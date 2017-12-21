package kr.co.ezenac.tbja.sampledev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import kr.co.ezenac.tbja.sampledev.adapter.GridAdapter;
import kr.co.ezenac.tbja.sampledev.model.GridItem;

public class GridViewActivity extends AppCompatActivity {
    ArrayList<GridItem> items = new ArrayList<>();
    GridView gridView;
    GridAdapter gridAdapter;

    String[] color = {"#ff0000","#00ff00","#0000ff"};
    String[] name = {"RED","GREEN","BLUE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        gridView = findViewById(R.id.grid_view);

        for (int i = 0 ; i < 10 ; i++) {
            int ran = (int) (Math.random()*color.length);
            GridItem item = new GridItem(color[ran],name[ran]);
            items.add(item);
        }

        gridAdapter = new GridAdapter(items);
        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                GridItem item = items.get(i);

                Toast.makeText(GridViewActivity.this,"position : " + i,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
