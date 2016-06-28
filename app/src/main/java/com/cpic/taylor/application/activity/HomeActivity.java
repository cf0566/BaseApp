package com.cpic.taylor.application.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.cpic.taylor.application.R;
import com.cpic.taylor.application.base.BaseActivity;
import com.cpic.taylor.application.fragment.DiscoverFragment;
import com.cpic.taylor.application.fragment.HomeFragment;
import com.cpic.taylor.application.fragment.MineFragment;
import com.cpic.taylor.application.fragment.NewsFragment;

import java.util.ArrayList;

public class HomeActivity extends BaseActivity {

    ViewPager pager;
    ArrayList<Fragment> list = new ArrayList<Fragment>();

    private RadioGroup rGroup;
    private RadioButton rBtn00, rBtn01, rBtn02, rBtn03;

    private TextView tvTitle;


    // 上一次选择的rbtn
    private RadioButton lastButton;
    // Fragment的管理类
    private FragmentManager mManager;
    // Fragment的事务类
    private FragmentTransaction mTrans;
    // 管理Fragment的List集合

    @Override
    protected void getIntentData(Bundle savedInstanceState) {

    }

    @Override
    protected void loadXml() {
        setContentView(R.layout.activity_home);
    }

    @Override
    protected void registerListener() {
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        rBtn00.setChecked(true);
                        break;
                    case 1:
                        rBtn01.setChecked(true);
                        break;
                    case 2:
                        rBtn02.setChecked(true);
                        break;
                    case 3:
                        rBtn03.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.activity_main_rbtn00:
                        pager.setCurrentItem(0);
                        tvTitle.setText(rBtn00.getText().toString());
                        break;
                    case R.id.activity_main_rbtn01:
                        pager.setCurrentItem(1);
                        tvTitle.setText(rBtn01.getText().toString());
                        break;
                    case R.id.activity_main_rbtn02:
                        pager.setCurrentItem(2);
                        tvTitle.setText(rBtn02.getText().toString());
                        break;
                    case R.id.activity_main_rbtn03:
                        pager.setCurrentItem(3);
                        tvTitle.setText(rBtn03.getText().toString());
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    protected void initView() {
        rGroup = (RadioGroup) findViewById(R.id.activity_main_rgroup);
        pager = (ViewPager) findViewById(R.id.activity_main_vp);
        rBtn00 = (RadioButton) findViewById(R.id.activity_main_rbtn00);
        rBtn01 = (RadioButton) findViewById(R.id.activity_main_rbtn01);
        rBtn02 = (RadioButton) findViewById(R.id.activity_main_rbtn02);
        rBtn03 = (RadioButton) findViewById(R.id.activity_main_rbtn03);
        tvTitle = (TextView) findViewById(R.id.activity_main_tv);
    }

    @Override
    protected void initData() {
        list.add(new HomeFragment());
        list.add(new NewsFragment());
        list.add(new DiscoverFragment());
        list.add(new MineFragment());

        pager.setAdapter(new MyGiftPagerAdapter(getSupportFragmentManager()));
        rGroup.check(R.id.activity_main_rbtn00);
    }


    class MyGiftPagerAdapter extends FragmentPagerAdapter {

        public MyGiftPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int arg0) {
            return list.get(arg0);
        }
        @Override
        public int getCount() {
            return list.size();
        }
    }
}
