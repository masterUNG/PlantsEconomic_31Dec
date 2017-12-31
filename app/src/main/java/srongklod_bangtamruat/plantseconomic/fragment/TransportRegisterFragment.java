package srongklod_bangtamruat.plantseconomic.fragment;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import srongklod_bangtamruat.plantseconomic.R;
import srongklod_bangtamruat.plantseconomic.utility.MyAlert;
import srongklod_bangtamruat.plantseconomic.utility.TransportModel;

/**
 * Created by Administrator on 12/11/2560.
 */

public class TransportRegisterFragment extends Fragment {

    //    Explicit
    private String companyString, addressString, faxString, telephoneString, branchString, emailString,
            passwordString, headquarterString,uidUserString;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private DatabaseReference databaseReference;
    private ProgressDialog progressDialog;
    private TransportModel transportModel;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        SaveController
        savecontroller();
    }

    private void savecontroller() {
        Button button = getView().findViewById(R.id.btnTransport);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Initial EditText
                EditText companyEditText = getView().findViewById(R.id.edtCompanyName);
                EditText addressEditText = getView().findViewById(R.id.edtAddress);
                EditText faxEditText = getView().findViewById(R.id.edtFax);
                EditText telephoneEditText = getView().findViewById(R.id.edtTelephone);
                EditText branchEditText = getView().findViewById(R.id.edtBranch);
                EditText emailEditText = getView().findViewById(R.id.edtEmail);
                EditText passwordEditText = getView().findViewById(R.id.edtPassword);
                EditText headquarterEditText = getView().findViewById(R.id.edtHead);

//                Get Value from EdtText
                companyString = companyEditText.getText().toString().trim();
                addressString = addressEditText.getText().toString().trim();
                faxString = faxEditText.getText().toString().trim();
                telephoneString = telephoneEditText.getText().toString().trim();
                branchString = branchEditText.getText().toString().trim();
                emailString = emailEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();
                headquarterString = headquarterEditText.getText().toString().trim();

//                Check Space
                if (checkSpace()) {
//                    Have Space
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.nomalDialog(getResources().getString(R.string.title_have_space),
                            getResources().getString(R.string.massage_have_space));

                } else {
//                    No Space
                    confirmValue();
                }

            }
        });

    }

    private void confirmValue() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIcon(R.drawable.ic_action_upload);
        builder.setCancelable(false);
        builder.setTitle("please Confirm Value");
        builder.setMessage("CompanyName = " + companyString + "\n" +
                "Address = " + addressString + "\n" +
                "Fax = " + faxString + "\n" +
                "Telephone = " + telephoneString + "\n" +
                "Branch = " + branchString + "\n" +
                "Email = " + emailString + "\n" +
                "Password = " + passwordString + "\n" +
                "Head_Quarter = " + headquarterString);
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                uploadValueFriebase();
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    private void uploadValueFriebase() {

//        Set up Progress
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Please Wait few Minus...");
        progressDialog.setMessage("Continue Upload Database");
        progressDialog.show();

//        For Authentication
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(emailString, passwordString)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            completeTask();

                        } else {
                            String resultError = task.getException().getMessage();
                            MyAlert myAlert = new MyAlert(getActivity());
                            myAlert.nomalDialog("Cannot Upload Transport", resultError);

                        }

                    }
                });

    }

    private void completeTask() {

        String tag = "27DecV3";
//        For Database
        firebaseUser = firebaseAuth.getCurrentUser();
        uidUserString = firebaseUser.getUid();
        Log.d(tag, "uid of Current Login ==>" + uidUserString);

//        Setup Model
        transportModel = new TransportModel(
                uidUserString,
                companyString,
                addressString,
                faxString,
                telephoneString,
                branchString,
                headquarterString);

        UserProfileChangeRequest userProfileChangeRequest = new UserProfileChangeRequest
                .Builder().setDisplayName(companyString).build();

        firebaseUser.updateProfile(userProfileChangeRequest).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {

                databaseReference = FirebaseDatabase.getInstance().getReference().child("Transport");
                databaseReference.child(uidUserString).setValue(transportModel);

//        For Authentication
                Toast.makeText(getActivity(),"Upload Success",
                        Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

                getActivity().getSupportFragmentManager().popBackStack();


            }
        });







    }   // Complete Task


    private boolean checkSpace() {
        return companyString.equals("") ||
                addressString.equals("") ||
                faxString.equals("") ||
                telephoneString.equals("") ||
                branchString.equals("") ||
                emailString.equals("") ||
                passwordString.equals("") ||
                headquarterString.equals("");


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transport_register, container, false);
        return view;
    }
}//Main Class