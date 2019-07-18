package com.app.nb.tabby.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.app.nb.tabby.fragment.PersonFormFragment;
import com.app.nb.tabby.fragment.PersonListFragment;

import static com.app.nb.tabby.activities.MainActivity.PERSON_FORM_FRAGMENT;
import static com.app.nb.tabby.activities.MainActivity.PERSON_LIST_FRAGMENT;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    // numero de tabs
    private int numbreOfTabs;


    public ViewPagerAdapter(FragmentManager fm, int numbreOfTabs) {
        super(fm);
        this.numbreOfTabs = numbreOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        //Depediendo del la posicion
        //Se laza en cada swipe o click
        switch (position) {
            case PERSON_FORM_FRAGMENT:
                return new PersonFormFragment();
            case PERSON_LIST_FRAGMENT:
                return new PersonListFragment();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return numbreOfTabs;
    }
}
