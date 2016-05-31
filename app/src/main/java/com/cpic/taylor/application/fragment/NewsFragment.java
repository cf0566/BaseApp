package com.cpic.taylor.application.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cpic.taylor.application.R;
import com.cpic.taylor.application.library.PullToRefreshBase;
import com.cpic.taylor.application.library.PullToRefreshListView;
import com.cpic.taylor.application.utils.ToastUtils;

/**
 * Created by Taylor on 2016/5/30.
 */
public class NewsFragment extends Fragment{

    private PullToRefreshListView plv;
    private ArrayAdapter<String> adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news,null);
        plv = (PullToRefreshListView) view.findViewById(R.id.fragment_news_plv);

        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1);
        for (int i = 0;i < 20;i ++){
            adapter.add("测试"+i+"号");
        }
        plv.setAdapter(adapter);
        registerListener();
        return view;
    }

    private void registerListener() {

        plv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {

            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

                ToastUtils.showToast(getActivity(),"下拉刷新");
                adapter.add("下拉刷新");
                adapter.notifyDataSetChanged();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        plv.onRefreshComplete();
                    }
                }, 10);

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                ToastUtils.showToast(getActivity(),"上拉加载");

            }
        });


    }
}
