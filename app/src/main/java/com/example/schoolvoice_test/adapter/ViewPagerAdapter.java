package com.example.schoolvoice_test.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.schoolvoice_test.fragments.LikesFragment;
import com.example.schoolvoice_test.fragments.ViewsFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i)
        {
            case 0:
                return new ViewsFragment(); //ViewsFragment at position 0
            case 1:
                return new LikesFragment(); //LikesFragment at position 1

        }
        return null; //does not happen
    }

    @Override
    public int getCount() {
        return 2;
    }
}
