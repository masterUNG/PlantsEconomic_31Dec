package srongklod_bangtamruat.plantseconomic.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import srongklod_bangtamruat.plantseconomic.R;
import srongklod_bangtamruat.plantseconomic.utility.DrawerListViewAdapter;
import srongklod_bangtamruat.plantseconomic.utility.MyConstant;

/**
 * Created by masterung on 31/12/2017 AD.
 */

public class DrawerMenuCustomerFragment extends Fragment{

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

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




    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drawer_menu_customer, container, false);
        return view;
    }
}
