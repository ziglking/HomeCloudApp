package com.test.androidstudy.homecloud.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.test.androidstudy.homecloud.R;

/**
 * Created by wangxiang on 2017/11/19.
 */

public class ChartsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
    }

    public static void launch(Context context) {
        Intent intent = new Intent(context, ChartsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        context.startActivity(intent);
    }
}
