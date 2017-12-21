package kr.co.ezenac.tbja.sampledev.Fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import kr.co.ezenac.tbja.sampledev.R;

/**
 * Created by Administrator on 2017-12-12.
 */

public class Test2Fragment extends Fragment {
    Button btn_frag_2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_2_layout, container, false);
        btn_frag_2 = view.findViewById(R.id.btn_frag_2);

        btn_frag_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"test",Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

    public void test() {
        Toast.makeText(getContext(),"aaaa",Toast.LENGTH_LONG).show();
    }
}
