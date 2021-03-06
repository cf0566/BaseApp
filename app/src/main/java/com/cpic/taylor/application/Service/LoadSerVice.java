package com.cpic.taylor.application.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.http.HttpHandler;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;

import java.io.File;
import java.util.Random;

/**
 * Created by Taylor on 2016/5/31.
 */
public class LoadService extends Service{

    private Random random;
    private int bg;
    private HttpUtils post;
    private HttpHandler<File> handler;

    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {
    }



    public class MyBinder extends Binder {
        public void start(String url){
            startService(url);
        }
        public void pause(){
            handler.pause();
        }
        public void resume(){
            handler.resume();
        }
    }
    public void startService(String url){
        post = new HttpUtils();
        handler = post.download( url// 文件的下载路径,
                , Environment.getExternalStorageDirectory().getAbsolutePath()+ "/load/"+ System.currentTimeMillis()+".jpg", // 指定文件下载后的存储地址
                true, // 设置支持断点续传
                false, // 设置是否支持自动重命名文件
                new RequestCallBack<File>() {

                    @Override
                    public void onSuccess(ResponseInfo<File> arg0) {
                    }

                    @Override
                    public void onFailure(com.lidroid.xutils.exception.HttpException arg0,String arg1) {
                    }
                    /*
                     * 1: 数据的总长度 2: 数据的当前长度 3：本次的进度更新是否是文件的上传操作
                     */
                    @Override
                    public void onLoading(long total, long current,boolean isUploading) {
                        super.onLoading(total, current, isUploading);
                        Log.i("oye",total+"----"+current+"-------"+isUploading);
                    }

                    @Override
                    public void onStart() {
                        super.onStart();
                    }
                });
    }

}
