package com.example.administrator.my_note.weekFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.my_note.R;
import java.util.ArrayList;
import java.util.List;

public class WeekFragment extends Fragment {
    private TabLayout hd_tl;
    private ViewPager hd_vp;
    List<String> listStr; //用于存放添加Fragment的结合
    List<Fragment> listTv;//用于存放Fragment的集合
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.week_view,null);
        //找控件
        hd_tl = view.findViewById(R.id.week_Tab);
        hd_vp = view.findViewById(R.id.mViewPager_week);
        //TabLayout的横向布局  添加数据
        listStr = new ArrayList();
        listStr.add("全部");
        listStr.add("综艺娱乐");
        listStr.add("财经访谈");
        listStr.add("文化旅游");
        listStr.add("时尚体育");
        listStr.add("青少科技");
        listStr.add("养生保健");
        listStr.add("公益");
        listTv = new ArrayList<>();
//        //第一个Fragment界面
//        listTv.add(new FragmentQuan());
//        listStr.get(0);
        //剩下的7个Fragment
        for (int i = 0; i < 7; i++) {
            hd_tl.addTab(hd_tl.newTab().setText(listStr.get(i)));
            listTv.add(new DateFragment());
        }
        //拿到适配器
        MyPagerAdapter adapter = new MyPagerAdapter(getChildFragmentManager());
        hd_vp.setAdapter(adapter);
        //ViewpAge的预加载解决方法
        hd_vp.setOffscreenPageLimit(listTv.size());
        //TabLayout和ViewPage进行联动
        hd_tl.setupWithViewPager(hd_vp);
        return view;
    }
    //ViewPage的适配器
    class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return listTv.get(position);
        }
        @Override
        public int getCount() {
            return listTv.size();
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return listStr.get(position);
        }
    }
}
