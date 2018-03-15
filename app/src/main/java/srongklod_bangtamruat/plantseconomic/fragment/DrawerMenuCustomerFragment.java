package srongklod_bangtamruat.plantseconomic.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import srongklod_bangtamruat.plantseconomic.R;
import srongklod_bangtamruat.plantseconomic.ServiceActivity;
import srongklod_bangtamruat.plantseconomic.utility.DrawerListViewAdapter;
import srongklod_bangtamruat.plantseconomic.utility.MyConstant;

/**
 * Created by masterung on 31/12/2017 AD.
 */

public class DrawerMenuCustomerFragment extends Fragment{

    private String[] loginStrings;

    public static DrawerMenuCustomerFragment drawerMenuCustomerInstance(String[] loginStrings) {

        DrawerMenuCustomerFragment drawerMenuCustomerFragment = new DrawerMenuCustomerFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray("Login", loginStrings);
        drawerMenuCustomerFragment.setArguments(bundle);
        return drawerMenuCustomerFragment;

    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Get Value From Argument
        loginStrings = getArguments().getStringArray("Login");


//        Create ListView
        createListView();

    }

    private void createListView() {

        ListView listView = getView().findViewById(R.id.listViewCustomDrawer);
        MyConstant myConstant = new MyConstant();

//        Icon
        int[] ints = myConstant.getIconCustomerInts();

//        Title
        String[] strings = myConstant.getTitleCustomerStrings();

        DrawerListViewAdapter drawerListViewAdapter = new DrawerListViewAdapter(
                getActivity(),
                ints,
                strings);
        listView.setAdapter(drawerListViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                switch (i) {

                    case 0:

                        getActivity().getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.contentServiceFragment, CustomerShowFragment.customerShowInstance(loginStrings))
                                .commit();

                        break;
                    case 1:

                        getActivity().getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.contentServiceFragment, new AddFriendCustomerFragment())
                                .commit();

                        break;

                }   // switch

//                DrawerLayout drawerLayout = getView().findViewById(R.id.drawerLayoutService);
//                drawerLayout.closeDrawer(GravityCompat.START);


            }
        });




    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drawer_menu_customer, container, false);
        return view;
    }
}
