package com.learning.manojkumar.resume.controller;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.learning.manojkumar.resume.R;
import com.learning.manojkumar.resume.views.Education;
import com.learning.manojkumar.resume.views.Experience;
import com.learning.manojkumar.resume.views.Skills;

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private Context context;
    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }



    @Override
    public Fragment getItem(int position) {

        if(position == 0) {
            return new Experience();
        }
        else if (position == 1){
            return new Education();
        }

        else {
            return new Skills();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0)
            return context.getString(R.string.experience);
        else if (position == 1)
            return context.getString(R.string.education);
        else
            return context.getString(R.string.skills);
    }
}
