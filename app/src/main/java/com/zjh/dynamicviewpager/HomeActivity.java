package com.zjh.dynamicviewpager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView pagerFragmentTV = findViewById(R.id.tv_pager_fragment);
        pagerFragmentTV.setOnClickListener(this);

        TextView pagerViewTV = findViewById(R.id.tv_pager_view);
        pagerViewTV.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_pager_fragment:
                Intent intentFragment = new Intent(HomeActivity.this, PagerFragmentActivity.class);
                startActivity(intentFragment);
                break;
            case R.id.tv_pager_view:
                Intent intentView = new Intent(HomeActivity.this, PagerViewActivity.class);
                startActivity(intentView);
                break;
        }
    }
}
