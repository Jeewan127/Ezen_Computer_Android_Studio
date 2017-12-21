package kr.co.ezenac.tbja.sampledev.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import kr.co.ezenac.tbja.sampledev.Fragment.Test1Fragment;
import kr.co.ezenac.tbja.sampledev.Fragment.Test2Fragment;
import kr.co.ezenac.tbja.sampledev.Fragment.Test3Fragment;

/**
 * Created by Administrator on 2017-12-12.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new Test1Fragment();
        } else if (position == 1){
            return new Test2Fragment();
        } else {
            return new Test3Fragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
