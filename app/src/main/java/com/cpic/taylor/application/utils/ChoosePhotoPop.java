package com.cpic.taylor.application.utils;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.cpic.taylor.application.R;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Taylor on 2016/5/27.
 */
public class ChoosePhotoPop {

    private PopupWindow pw;
    private TextView tvCamera, tvPhoto, tvBack;
    private int screenWidth;
    private Activity activity;

    private static final int PHOTO_REQUEST_TAKEPHOTO = 1;// 拍照
    private static final int PHOTO_REQUEST_GALLERY = 2;// 从相册中选择
    private static final int PHOTO_REQUEST_CUT = 3;// 结果
    // 创建一个以当前时间为名称的文件
    private File tempFile ;

    public ChoosePhotoPop(Activity activity) {
        this.activity = activity;
    }

    public File getCameraPic(){
        return tempFile;
    }

    public void choosePhoto() {
        View view = View.inflate(activity, R.layout.popupwindow_choose_icon, null);
        tvCamera = (TextView) view.findViewById(R.id.btn_camera);
        tvPhoto = (TextView) view.findViewById(R.id.btn_photo);
        tvBack = (TextView) view.findViewById(R.id.btn_back);

        screenWidth = DisplayScreen.screenWidth(activity);
        tvCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 调用系统的拍照功能
                tempFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+ "/"+ System.currentTimeMillis()+".jpg");
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                // 指定调用相机拍照后照片的储存路径
//                Log.i("oye",tempFile+"");
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile));
                activity.startActivityForResult(intent, PHOTO_REQUEST_TAKEPHOTO);
                pw.dismiss();
            }
        });

        tvPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, null);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                activity.startActivityForResult(intent, PHOTO_REQUEST_GALLERY);
                pw.dismiss();
            }
        });
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pw.dismiss();
            }
        });
        pw = new PopupWindow(view, screenWidth * 99 / 100, LinearLayout.LayoutParams.WRAP_CONTENT);
        pw.setFocusable(true);
        pw.setBackgroundDrawable(new ColorDrawable());
        pw.setOutsideTouchable(true);
        pw.setAnimationStyle(R.style.pw_anim_style);
        pw.showAtLocation(view, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
    }

    // 使用系统当前日期加以调整作为照片的名称
    private String getPhotoFileName() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("'IMG'_yyyyMMdd_HHmmss");
        return dateFormat.format(date) + ".jpg";
    }

}
