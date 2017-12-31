package srongklod_bangtamruat.plantseconomic.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import srongklod_bangtamruat.plantseconomic.MainActivity;
import srongklod_bangtamruat.plantseconomic.R;
import srongklod_bangtamruat.plantseconomic.utility.PagerAdapter;

/**
 * Created by Administrator on 5/11/2560.
 */

public class RegisterFragment extends Fragment{
    //Explicit
    private TabLayout tabLayout;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Create Toolbar
        createToolbar();

//        Create Tablayout
        createTablayout();

//        Create Viewpager
        createViewpager();

    }//Main Method

    private void createViewpager() {

        final ViewPager viewPager = getView().findViewById(R.id.viewPagerRegister);
        PagerAdapter pagerAdapter = new PagerAdapter(getActivity().getSupportFragmentManager(),
                tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void createTablayout() {

        tabLayout = getView().findViewById(R.id.tablayoutRegister);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.Customer));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.supplier));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.Transport));
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);//Char is Center
    }

    private void createToolbar() {
//        Setup Toolbar
        Toolbar toolbar = getView().findViewById(R.id.toolbarRegister);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);

//        SetTitle Toolbar
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(getResources()
        .getString(R.string.register));

//        set Navigator icon
        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);//Click wapwap
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             getActivity().getSupportFragmentManager().popBackStack();//back page fret


            }
        });


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        return view;
    }
}//Main Class
