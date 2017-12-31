package srongklod_bangtamruat.plantseconomic.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import srongklod_bangtamruat.plantseconomic.R;

/**
 * Created by masterung on 30/12/2017 AD.
 */

public class SupplierShowFragment extends Fragment{

    private String[] supplierStrings;

    public static SupplierShowFragment supplierShowInstance(String[] supplierStrings) {

        SupplierShowFragment supplierShowFragment = new SupplierShowFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray("Supplier", supplierStrings);
        supplierShowFragment.setArguments(bundle);
        return supplierShowFragment;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Get Value From Activity
        supplierStrings = getArguments().getStringArray("Supplier");

//        Show Text
        showText();


    }   // Main Method

    private void showText() {
        TextView textView = getView().findViewById(R.id.txtShowSupplier);
        textView.setText(supplierStrings[2]);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_supplier_show, container, false);
        return view;
    }
}   // Main Class
