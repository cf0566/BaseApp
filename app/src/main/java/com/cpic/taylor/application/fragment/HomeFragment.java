package com.cpic.taylor.application.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cpic.taylor.application.R;
import com.cpic.taylor.application.activity.TakePhotoActivity;

/**
 * Created by Taylor on 2016/5/30.
 */
public class HomeFragment extends Fragment{

    private Button btn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,null);

        initView(view);

        registerListener();
        return view;
    }

    private void registerListener() {

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TakePhotoActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initView(View view) {
        btn = (Button) view.findViewById(R.id.fragment_home_btn_main);
    }
}
