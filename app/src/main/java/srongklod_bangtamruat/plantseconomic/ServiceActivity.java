package srongklod_bangtamruat.plantseconomic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import srongklod_bangtamruat.plantseconomic.fragment.CustomerShowFragment;
import srongklod_bangtamruat.plantseconomic.fragment.SupplierShowFragment;
import srongklod_bangtamruat.plantseconomic.fragment.TransportShowFragment;
import srongklod_bangtamruat.plantseconomic.utility.CustomerModel;
import srongklod_bangtamruat.plantseconomic.utility.MyConstant;
import srongklod_bangtamruat.plantseconomic.utility.SupplierModel;
import srongklod_bangtamruat.plantseconomic.utility.TransportModel;

public class ServiceActivity extends AppCompatActivity {

    //    Explicit
//    About Firebase
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;


    //    General
    private String tag = "30DecV1";
    private String userUidString;
    private boolean statusABoolean = true; // true ==> Don't Find userUid ?


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

//        Find User uid
        findUserUid();

//        Find userUid in Customer
        findUserUidinCustomer();

//        Find userUid in Supplier
        findUserUidinSupplier();


//        Find userUid in Transport
        findUserUidinTransport();


    }   // Main Method

    private void findUserUidinTransport() {

        Log.d("31DecV1", "status ==> " + statusABoolean);

        if (statusABoolean) {

            MyConstant myConstant = new MyConstant();
            String[] fieldStrings = myConstant.getFieldTransportStrings();
            final String[] transportStrings = new String[fieldStrings.length];

            DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                    .getReference().child("Transport");
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    List list = new ArrayList();
                    int i = 0;

                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                        TransportModel transportModel = dataSnapshot1.getValue(TransportModel.class);
                        list.add(transportModel);

                        TransportModel transportModel1 = (TransportModel) list.get(i);

                        if (userUidString.equals(transportModel1.getUidUserString())) {

                            statusABoolean = false;
                            transportStrings[0] = transportModel1.getAddressString();
                            transportStrings[1] = transportModel1.getBranchString();
                            transportStrings[2] = transportModel1.getCompanyString();
                            transportStrings[3] = transportModel1.getFaxString();
                            transportStrings[4] = transportModel1.getHeadquarterString();
                            transportStrings[5] = transportModel1.getTelephoneString();
                            transportStrings[6] = transportModel1.getUidUserString();

                           for (int i1=0; i1<transportStrings.length; i1+=1) {
                               Log.d("31DecV1", "transportString[" + i1 + "] => " + transportStrings[i1]);
                           }



                            getSupportFragmentManager()
                                    .beginTransaction()
                                    .add(R.id.contentServiceFragment, TransportShowFragment.transportShowInstance(transportStrings))
                                    .commit();


                        }   // if

                        i = i + 1;

                    }   // for

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }   // if

    }

    private void findUserUidinSupplier() {

        if (statusABoolean) {

            MyConstant myConstant = new MyConstant();
            String[] fieldStrings = myConstant.getFieldSupplierStrings();
            final String[] supplyStrings = new String[fieldStrings.length];

            DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                    .getReference().child("Supplier");
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    List list = new ArrayList();
                    int i = 0;

                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                        SupplierModel supplierModel = dataSnapshot1.getValue(SupplierModel.class);
                        list.add(supplierModel);

                        SupplierModel supplierModel1 = (SupplierModel) list.get(i);

                        if (userUidString.equals(supplierModel1.getUidUserString())) {

                            statusABoolean = false;
                            supplyStrings[0] = supplierModel1.getAddressString();
                            supplyStrings[1] = supplierModel1.getBussinessString();
                            supplyStrings[2] = supplierModel1.getCompanyString();
                            supplyStrings[3] = supplierModel1.getFaxString();
                            supplyStrings[4] = supplierModel1.getHeadquartersString();
                            supplyStrings[5] = supplierModel1.getTelephoneString();
                            supplyStrings[6] = supplierModel1.getUidUserString();

                            getSupportFragmentManager()
                                    .beginTransaction()
                                    .add(R.id.contentServiceFragment, SupplierShowFragment.supplierShowInstance(supplyStrings))
                                    .commit();

                        }   // if

                        i = i + 1;

                    }   //for


                }   // onDatachange

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }   // if

    }

    private void findUserUidinCustomer() {
        if (statusABoolean) {

            //   FirebaseDatabase.getInstance().setPersistenceEnabled(true);

            MyConstant myConstant = new MyConstant();
            String[] fieldStrings = myConstant.getFieldCustomerStrings();
            final String[] customerStrings = new String[fieldStrings.length];

            DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                    .getReference().child("Customer");

            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    List list = new ArrayList();
                    int timesAInt = 0;

                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                        CustomerModel customerModel = dataSnapshot1.getValue(CustomerModel.class);
                        list.add(customerModel);


                        CustomerModel customerModel1 = (CustomerModel) list.get(timesAInt);
                        Log.d(tag, "Name[" + timesAInt + "] ==> " + customerModel1.getNameString());
                        timesAInt = timesAInt + 1;


                        if (userUidString.equals(customerModel1.getUidUserString())) {
                            statusABoolean = false;

                            customerStrings[0] = customerModel1.getLastNameString();
                            customerStrings[1] = customerModel1.getNameString();
                            customerStrings[2] = customerModel1.getPhoneString();
                            customerStrings[3] = customerModel1.getUidUserString();

                            for (int i = 0; i < customerStrings.length; i += 1) {
                                Log.d(tag, "custom[" + i + "] ==> " + customerStrings[i]);
                            }

                            getSupportFragmentManager().beginTransaction()
                                    .add(R.id.contentServiceFragment,
                                            CustomerShowFragment.customerShowInstance(customerStrings))
                                    .commit();

                        }   // if

                    }   // for

                    Log.d(tag, "Status ==> " + statusABoolean);

                }   // onDataChange

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


        }   // if
    }

    private void findUserUid() {
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        userUidString = firebaseUser.getUid();
        String disPlayName = firebaseUser.getDisplayName();
        Log.d(tag, "at Service userUid ==> " + userUidString);
        Log.d(tag, "disPlayName ==> " + disPlayName);
    }


}   // Main Class
