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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import srongklod_bangtamruat.plantseconomic.R;
import srongklod_bangtamruat.plantseconomic.utility.MyConstant;
import srongklod_bangtamruat.plantseconomic.utility.ShopModel;

public class ListShopWhereByCategoryFragment extends Fragment {

    private int intdexAnInt;
    private ArrayList<String> nameShopStringArrayList, nameProduceStringArrayList;
    private ListView listView;
    private String mainChildString = "ShopSupplier", categoryString;
    private ArrayList<String> nameStringArrayList, descriptionStringArrayList,
            priceStringsStringArrayList, imageStringArrayList, stockStringArrayList;

    public static ListShopWhereByCategoryFragment listShopWhereByCategoryInstance(int indexInt) {

        ListShopWhereByCategoryFragment listShopWhereByCategoryFragment = new ListShopWhereByCategoryFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("Index", indexInt);
        listShopWhereByCategoryFragment.setArguments(bundle);
        return listShopWhereByCategoryFragment;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Setup ArrayList
        setupArrayList();

//        Show Category
        showCategory();

//        Create ListView
        createListView();

    }   // Main Method

    private void setupArrayList() {
        nameStringArrayList = new ArrayList<>();
        descriptionStringArrayList = new ArrayList<>();
        priceStringsStringArrayList = new ArrayList<>();
        imageStringArrayList = new ArrayList<>();
        stockStringArrayList = new ArrayList<>();
    }

    private void createListView() {

        listView = getView().findViewById(R.id.listShowShop);
        nameShopStringArrayList = new ArrayList<>();

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference().child(mainChildString);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                    nameShopStringArrayList.add(dataSnapshot1.getKey());

                }   // for

                Log.d("28AprilV2", "nameShopArrayList ==> " + nameShopStringArrayList.toString());
                findProduct();


            }   // onDataChange

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }   // createListView

    private void findProduct() {

        nameProduceStringArrayList = new ArrayList<>();

        for (int i = 0; i < nameShopStringArrayList.size(); i += 1) {

            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference()
                    .child(mainChildString)
                    .child(nameShopStringArrayList.get(i));

            final int finalI = i;
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                        nameProduceStringArrayList.add(dataSnapshot1.getKey());

                    }   // for

                    Log.d("28AprilV3", "nameProduce ==> " + nameProduceStringArrayList.toString());
                    createArrayListForShow(nameShopStringArrayList.get(finalI));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


        }   // for


    }

    private void createArrayListForShow(String nameShopString) {

        for (int i = 0; i<nameProduceStringArrayList.size(); i+=1) {

            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference()
                    .child(mainChildString)
                    .child(nameShopString)
                    .child(nameProduceStringArrayList.get(i));

            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    int[] ints = new int[]{0};
                    List stringArrayList = new ArrayList<>();
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                        ShopModel shopModel = dataSnapshot1.getValue(ShopModel.class);
                        stringArrayList.add(shopModel);

                        ShopModel shopModel1 = (ShopModel) stringArrayList.get(ints[0]);

                        if (categoryString.equals(shopModel1.getCategoryString())) {

                            nameStringArrayList.add(shopModel1.getNameProduceString());



                        }


                        ints[0] += 1;
                    }   // for

                    Log.d("28AprilV3", "Name Product ==> " + nameStringArrayList);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }   // for



    }

    private void showCategory() {
        intdexAnInt = getArguments().getInt("Index", 0);
        Log.d("28AprilV1", "Receive Index ==> " + intdexAnInt);

        TextView textView = getView().findViewById(R.id.txtTitle);
        MyConstant myConstant = new MyConstant();
        String[] strings = myConstant.getCategoryShopStrings();
        categoryString = strings[intdexAnInt];
        textView.setText(strings[intdexAnInt]);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_shop_category, container, false);
        return view;
    }
}
