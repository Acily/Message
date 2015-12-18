package com.app.gaohailong.message;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by donglinghao on 2015-10-10.
 */
public class TabActivity extends AppCompatActivity {
    private TabLayout mTablayout;
    private ViewPager mViewPager;
    private String[] mTitles = new String[]{"节日短信","发送记录"};
    private List<Fragment> mFragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab);

        initViews();

        initEvent();
    }

    private void initEvent() {
    }

    private void initViews() {
        mTablayout = (TabLayout) findViewById(R.id.id_tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.id_view_pager);

        mFragments = new ArrayList<Fragment>();
        Fragment mFestivalFragment = new FestivalFragment();
        Fragment mRecordFragment = new RecordFragment();
        mFragments.add(mFestivalFragment);
        mFragments.add(mRecordFragment);

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();  //mTitles.length
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles[position];
            }
        });

        mTablayout.setupWithViewPager(mViewPager);
    }
}
