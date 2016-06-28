package com.cpic.taylor.application.activity;

import android.os.Bundle;

import com.cpic.taylor.application.R;
import com.cpic.taylor.application.base.BaseActivity;
import com.squareup.timessquare.CalendarPickerView;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Taylor on 2016/6/22.
 */
public class RecyclerActivity extends BaseActivity{


    @Override
    protected void getIntentData(Bundle savedInstanceState) {

    }

    @Override
    protected void loadXml() {
        setContentView(R.layout.autolayout_example);
    }

    @Override
    protected void initView() {
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 2);

        CalendarPickerView calendar = (CalendarPickerView) findViewById(R.id.calendar_view);
        Date today = new Date();
        calendar.init(today, nextYear.getTime()) .withSelectedDate(today);

    }
    @Override
    protected void initData(){

    }

    @Override
    protected void registerListener() {

    }


}
