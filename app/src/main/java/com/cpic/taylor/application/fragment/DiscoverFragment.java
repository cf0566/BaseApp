package com.cpic.taylor.application.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cpic.taylor.application.R;
import com.cpic.taylor.application.utils.NotificationUtils;

/**
 * Created by Taylor on 2016/5/30.
 */
public class DiscoverFragment extends Fragment{

    private Button btn,btn2,btn3;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover,null);

        btn = (Button) view.findViewById(R.id.fragment_dis_btn);
        btn2 = (Button) view.findViewById(R.id.button5);
        btn3 = (Button) view.findViewById(R.id.button6);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationUtils notificationUtils = new NotificationUtils();
                notificationUtils.UseNotifiCation(getActivity());
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return view;
    }
}
