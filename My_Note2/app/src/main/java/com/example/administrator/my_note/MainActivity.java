package com.example.administrator.my_note;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.*;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import com.example.administrator.my_note.mainFragment.FragmentMe;
import com.example.administrator.my_note.mainFragment.FragmentMonth;
import com.example.administrator.my_note.mainFragment.FragmentWeek;
import com.example.administrator.my_note.weekFragment.WeekFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiMainMenu();
        initFloatButton();
        new WeekFragment();



//
//        //设置 TabLayout 的监听器
//        mytab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//            //                添加选中Tab的逻辑
//            }
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//            //                添加未选中Tab的逻辑
//            }
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//            //                再次选中tab的逻辑
//            }
//        });;



//        //设置  Me  菜单的默认选项
//        navigationView.setCheckedItem(R.id.navigation_me_list);
//         //设置选项监听
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                //当选中确定后关闭关闭侧滑菜单
//                drawerLayout_setting.closeDrawers();
//                return true;
//            }
//        });


    }

    private void initFloatButton(){
        //对于浮动按钮的监听
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.addActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    protected BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mViewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    mViewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    mViewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };
    //启动主页面菜单
    private void intiMainMenu(){
        mViewPager=(ViewPager) findViewById(R.id.mViewPager);//获取到ViewPager
        final BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //ViewPager的监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                //写滑动页面后做的事，使每一个fragmen与一个page相对应
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        //Fragment列表，将fragment放入列表中，放入mPagerAdapter
        final ArrayList<Fragment> fgLists=new ArrayList<>(4);
        fgLists.add(new FragmentWeek());
        fgLists.add(new FragmentMonth());
        fgLists.add(new FragmentMe());
        FragmentPagerAdapter mPagerAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fgLists.get(position);
            }

            @Override
            public int getCount() {
                return fgLists.size();
            }
        };
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setOffscreenPageLimit(3);

    }


}
