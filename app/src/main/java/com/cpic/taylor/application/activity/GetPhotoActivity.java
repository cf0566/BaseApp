package com.cpic.taylor.application.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.cpic.taylor.application.R;
import com.cpic.taylor.application.adapter.MainGVAdapter;
import com.cpic.taylor.application.utils.ScreenUtils;
import com.cpic.taylor.application.utils.Utility;

import java.util.ArrayList;

/**
 * 主页面，可跳转至相册选择照片，并在此页面显示所选择的照片。
 * Created by hanj on 14-10-13.
 */
public class GetPhotoActivity extends Activity {
    private MainGVAdapter adapter;
    private ArrayList<String> imagePathList;
    private static final  int TAKE_PHOTO = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取屏幕像素
        ScreenUtils.initScreen(this);

        TextView titleTV = (TextView) findViewById(R.id.topbar_title_tv);
        Button selectImgBtn = (Button) findViewById(R.id.main_select_image);
        GridView mainGV = (GridView) findViewById(R.id.main_gridView);
        titleTV.setText(R.string.app_name);
        imagePathList = new ArrayList<String>();
        adapter = new MainGVAdapter(this, imagePathList);
        mainGV.setAdapter(adapter);

        selectImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转至最终的选择图片页面
                Intent intent = new Intent(GetPhotoActivity.this, PhotoWallActivity.class);
                startActivityForResult(intent,TAKE_PHOTO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TAKE_PHOTO){
            ArrayList<String> paths = data.getStringArrayListExtra("paths");
//            Log.i("oye",paths.size()+"");
            //添加，去重
            boolean hasUpdate = false;
            for (String path : paths) {
                if (!imagePathList.contains(path)) {
                    //最多9张
                    if (imagePathList.size() == 9) {
                        Utility.showToast(this, "最多可添加9张图片。");
                        break;
                    }
                    imagePathList.add(path);
                    hasUpdate = true;
                }
            }
            if (hasUpdate) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        int code = intent.getIntExtra("code", -1);
        if (code != 100) {
            return;
        }

        ArrayList<String> paths = intent.getStringArrayListExtra("paths");
        //添加，去重
        boolean hasUpdate = false;
        for (String path : paths) {
            if (!imagePathList.contains(path)) {
                //最多9张
                if (imagePathList.size() == 9) {
                    Utility.showToast(this, "最多可添加9张图片。");
                    break;
                }
                imagePathList.add(path);
                hasUpdate = true;
            }
        }
        if (hasUpdate) {
            adapter.notifyDataSetChanged();
        }
    }
}
