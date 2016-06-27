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
import com.cpic.taylor.application.activity.GetPhotoActivity;
import com.cpic.taylor.application.flash.FlashView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taylor on 2016/5/30.
 */
public class MineFragment extends Fragment{

    private Button btn;
    private FlashView flashView;

    private List<String> imgs ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine,null);
        btn = (Button) view.findViewById(R.id.button4);
        flashView = (FlashView) view.findViewById(R.id.flash_view);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GetPhotoActivity.class);
                startActivity(intent);
            }
        });
        imgs = new ArrayList<>();
        imgs.add("http://k.sinaimg.cn/n/sports/transform/20160524/rE9C-fxsktkr5972125.jpg/w570059.jpg");
        imgs.add("http://photocdn.sohu.com/20160120/Img435147530.jpg");
        imgs.add("http://img5.pcpop.com/ArticleImages/fnw/2016/0620/da423ebe-ea3d-4c40-a8b9-ad1e451531b1.jpg");
        flashView.setImageUris(imgs);
        return view;
    }
}
