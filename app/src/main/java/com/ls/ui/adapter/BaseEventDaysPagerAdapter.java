package com.ls.ui.adapter;


import com.ls.ui.drawer.DrawerMenu;
import com.ls.ui.fragment.EventFragment;
import com.ls.utils.DateUtils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class BaseEventDaysPagerAdapter extends FragmentStatePagerAdapter {

    private DrawerMenu.EventMode mEventMode;

    private List<Long> mDays;

    public BaseEventDaysPagerAdapter(FragmentManager fm) {
        super(fm);
        mDays = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        Long date = getDate(position);
        Fragment fragment = EventFragment.newInstance(date, mEventMode);
        return fragment;
    }

    public void setData(List<Long> eventDays, DrawerMenu.EventMode eventMode) {
        mDays.clear();
        mDays.addAll(eventDays);
        mEventMode = eventMode;
        notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return mDays.size();
    }

    public Long getDate(int position) {
        return mDays.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return DateUtils.getInstance().getWeekNameAndDate(getDate(position));
    }
}
