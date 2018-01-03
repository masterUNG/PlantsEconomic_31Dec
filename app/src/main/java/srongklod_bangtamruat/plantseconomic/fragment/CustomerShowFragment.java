package srongklod_bangtamruat.plantseconomic.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import srongklod_bangtamruat.plantseconomic.R;
import srongklod_bangtamruat.plantseconomic.ServiceActivity;
import srongklod_bangtamruat.plantseconomic.utility.MyAlert;

/**
 * Created by masterung on 30/12/2017 AD.
 */

public class CustomerShowFragment extends Fragment {

    //    Explicit
    private String[] customerStrings;
    private Uri uri;
    private ImageView imageView;


    public static CustomerShowFragment customerShowInstance(String[] customerStrings) {

        CustomerShowFragment customerShowFragment = new CustomerShowFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray("Customer", customerStrings);
        customerShowFragment.setArguments(bundle);
        return customerShowFragment;

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Get Value From Activity
        getValueFromArgument();

//        Show Text
        showText();

//        Image Controller
        imageController();

    }   // Main Method

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == getActivity().RESULT_OK) {

            //Show Image
            try {

                uri = data.getData();
                Bitmap bitmap = BitmapFactory
                        .decodeStream(getActivity().getContentResolver().openInputStream(uri));
                imageView.setImageBitmap(bitmap);


            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            MyAlert myAlert = new MyAlert(getActivity());
            myAlert.nomalDialog("Non Complete Choose Image",
                    getString(R.string.message_choose_image));
        }


    }

    private void imageController() {

        imageView = getView().findViewById(R.id.imvAvata);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, getString(R.string.message_choose_image)),
                        1);


            }
        });


    }

    private void showText() {

        TextView nameTextView = getView().findViewById(R.id.txtName);
        TextView lastNameTextView = getView().findViewById(R.id.txtLastName);
        TextView phoneTextView = getView().findViewById(R.id.txtPhone);

        nameTextView.setText(customerStrings[1]);
        lastNameTextView.setText(customerStrings[0]);
        phoneTextView.setText(customerStrings[2]);

    }

    private void getValueFromArgument() {
        customerStrings = getArguments().getStringArray("Customer");
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer_show, container, false);
        return view;
    }
}   // Main Class
