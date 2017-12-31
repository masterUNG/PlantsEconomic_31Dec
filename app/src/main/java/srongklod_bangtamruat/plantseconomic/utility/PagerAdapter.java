package srongklod_bangtamruat.plantseconomic.utility;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import srongklod_bangtamruat.plantseconomic.fragment.CustomerRegisterFragment;
import srongklod_bangtamruat.plantseconomic.fragment.SupplierRegisterFragment;
import srongklod_bangtamruat.plantseconomic.fragment.TransportRegisterFragment;

/**
 * Created by Administrator on 12/11/2560.
 */

public class PagerAdapter extends FragmentStatePagerAdapter{
    //Explicit
    private FragmentManager fragmentManager;
    private int anInt;

    public PagerAdapter(FragmentManager fragmentManager, int anInt) {
        super(fragmentManager);
        this.fragmentManager = fragmentManager;
        this.anInt = anInt;
    }//Constructor

    @Override
    public Fragment getItem(int position) {

       switch (position) {

            case 0:
                CustomerRegisterFragment customerRegisterFragment = new CustomerRegisterFragment();
                return customerRegisterFragment;
           case 1:
               SupplierRegisterFragment supplierRegisterFragment = new SupplierRegisterFragment();
               return supplierRegisterFragment;
           case 2:
               TransportRegisterFragment transportRegisterFragment = new TransportRegisterFragment();
               return transportRegisterFragment;
           default:
               return null;
        }

    }

    @Override
    public int getCount() {
        return anInt;
    }
}//Main Class
