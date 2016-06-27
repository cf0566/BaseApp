package com.cpic.taylor.application.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cpic.taylor.application.R;
import com.cpic.taylor.application.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taylor on 2016/6/22.
 */
public class RecyclerActivity extends BaseActivity{

    private RecyclerView recyclerView;
    private List<String> datas;
    private HomeAdapter mAdapter;


    @Override
    protected void getIntentData(Bundle savedInstanceState) {

    }

    @Override
    protected void loadXml() {
        setContentView(R.layout.autolayout_example);
    }

    @Override
    protected void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        initData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter = new HomeAdapter());
    }

    protected void initData()
    {
        datas = new ArrayList<String>();
        for (int i = 0; i < 20; i++)
        {
            datas.add(i+"");
        }
    }

    @Override
    protected void registerListener() {

    }

    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>
    {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(RecyclerActivity.this).inflate(R.layout.item_recyclerview, parent,false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position)
        {
            holder.tv.setText(datas.get(position));
        }

        @Override
        public int getItemCount()
        {
            return datas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder
        {

            TextView tv;

            public MyViewHolder(View view)
            {
                super(view);
                tv = (TextView) view.findViewById(R.id.re_tv);
            }
        }
    }

}
