package com.example.worldskills.tsp_psp;

import android.app.FragmentManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Proyectplansumary extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proyectplansumary);
        Adaptador adaptador= new Adaptador(getSupportFragmentManager());
        viewPager = findViewById(R.id.vp);
        viewPager.setAdapter(adaptador);
        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}

class Adaptador extends FragmentStatePagerAdapter{

    public Adaptador(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position){
            case 0:
                fragment = new Fragment1();
                break;
            case 1:
                fragment = new Fragment2();
                break;
            case 2:
                fragment = new Fragment3();
                break;

                default:return null;

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "TimeLog";
            case 1:
               return "DefectLog";
            case 2:
                return "Proyect Plan Sumary";

        }
        return null;
    }
}
