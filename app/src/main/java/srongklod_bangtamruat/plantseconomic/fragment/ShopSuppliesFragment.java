package srongklod_bangtamruat.plantseconomic.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import srongklod_bangtamruat.plantseconomic.R;
import srongklod_bangtamruat.plantseconomic.utility.ShopModel;
import srongklod_bangtamruat.plantseconomic.utility.ShopSupplierAdapter;

public class ShopSuppliesFragment extends Fragment {

    private String uidLoginString;
    private String[] nameStrings, descriptionStrings,
            priceStrings, stockStrings, urlPathStrings;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Find Login
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        uidLoginString = firebaseUser.getUid().toString();
        Log.d("5AprilV3", "uidLogin ==> " + uidLoginString);


//        Create ListView
        createListView();


    }   // Main Method

    private void createListView() {

        final ListView listView = getView().findViewById(R.id.listViewShopSupplier);
        final int[] countInts = new int[]{0};

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference()
                .child("ShopSupplier").child("Shop-" + uidLoginString);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                int amountProductInt = (int) dataSnapshot.getChildrenCount();
                nameStrings = new String[amountProductInt];
                descriptionStrings = new String[amountProductInt];
                priceStrings = new String[amountProductInt];
                stockStrings = new String[amountProductInt];
                urlPathStrings = new String[amountProductInt];

                List list = new ArrayList();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                    ShopModel shopModel = dataSnapshot1.getValue(ShopModel.class);
                    list.add(shopModel);

                    ShopModel shopModel1 = (ShopModel) list.get(countInts[0]);
                    Log.d("5AprilV3", "NameProduce[" + countInts[0] + "] ==> " + shopModel1.getNameProduceString());

                    nameStrings[countInts[0]] = shopModel1.getNameProduceString();
                    descriptionStrings[countInts[0]] = shopModel1.getDescreptionString();
                    priceStrings[countInts[0]] = shopModel1.getPriceString();
                    stockStrings[countInts[0]] = shopModel1.getStockString();
                    urlPathStrings[countInts[0]] = shopModel1.getUrlImagePathString();


                    countInts[0] += 1;
                }   // for

                ShopSupplierAdapter shopSupplierAdapter = new ShopSupplierAdapter(getActivity(),
                        nameStrings, descriptionStrings, priceStrings, stockStrings, urlPathStrings);
                listView.setAdapter(shopSupplierAdapter);


            }   // onDataChange

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }


    private void addShopSupplies() {
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contentServiceFragment, new AddShopFragment())
                .commit();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop_supplier, container, false);
        return view;
    }
}
