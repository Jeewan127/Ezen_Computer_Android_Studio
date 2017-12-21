package kr.co.ezenac.tbja.sampledev;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import kr.co.ezenac.tbja.sampledev.adapter.ViewPagerAdapter;

public class ViewPagerActivity extends AppCompatActivity {
    ViewPager viewpager_1;
    ViewPagerAdapter viewPagerAdapter;
    Button btn_tab_1;
    Button btn_tab_2;
    Button btn_tab_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        viewpager_1 = findViewById(R.id.viewpager_1);
        btn_tab_1 = findViewById(R.id.btn_tab_1);
        btn_tab_2 = findViewById(R.id.btn_tab_2);
        btn_tab_3 = findViewById(R.id.btn_tab_3);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewpager_1.setAdapter(viewPagerAdapter);

        btn_tab_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewpager_1.setCurrentItem(0);
            }
        });
        btn_tab_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewpager_1.setCurrentItem(1);
            }
        });
        btn_tab_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewpager_1.setCurrentItem(2);
            }
        });
    }
}
