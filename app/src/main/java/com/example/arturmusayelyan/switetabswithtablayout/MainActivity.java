package com.example.arturmusayelyan.switetabswithtablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.TabLayoutOnPageChangeListener;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {
    private ViewPager pager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.simpleTabLayout);
        TabLayout.Tab tab1 = tabLayout.newTab();
        tab1.setText("Tab1");

        TabLayout.Tab tab2 = tabLayout.newTab();
        tab2.setText("Tab2");

        TabLayout.Tab tab3 = tabLayout.newTab();
        tab3.setText("Tab3");

        tabLayout.addTab(tab1);
        tabLayout.addTab(tab2);
        tabLayout.addTab(tab3);
        //tabLayout.setOnTabSelectedListener(this); depreceted e
        tabLayout.addOnTabSelectedListener(this);

        pager = findViewById(R.id.pager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount()));
        pager.addOnPageChangeListener(new TabLayoutOnPageChangeListener(tabLayout));
    }


    //el kariq chka onPageChangeListener Override anelu
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        pager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
