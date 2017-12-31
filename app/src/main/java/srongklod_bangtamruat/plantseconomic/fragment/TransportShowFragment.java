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
 * Created by masterung on 31/12/2017 AD.
 */

public class TransportShowFragment extends Fragment{

    //    Explicit
    private String[] transportStrings;


    public static TransportShowFragment transportShowInstance(String[] transportStrings) {

        TransportShowFragment transportShowFragment = new TransportShowFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray("Transport", transportStrings);
        transportShowFragment.setArguments(bundle);
        return transportShowFragment;

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Get Valur From Argument
        transportStrings = getArguments().getStringArray("Transport");

//        Show Text
        showText();


    }   // Main Method

    private void showText() {

        TextView textView = getView().findViewById(R.id.txtShowTransport);
        textView.setText(transportStrings[2]);

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_transport_show, container, false);
        return view;

    }
}
