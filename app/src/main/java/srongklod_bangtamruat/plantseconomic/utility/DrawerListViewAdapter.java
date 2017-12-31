package srongklod_bangtamruat.plantseconomic.utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import srongklod_bangtamruat.plantseconomic.R;

/**
 * Created by masterung on 31/12/2017 AD.
 */

public class DrawerListViewAdapter extends BaseAdapter{

    private Context context;
    private int[] ints;
    private String[] strings;

    public DrawerListViewAdapter(Context context,
                                 int[] ints,
                                 String[] strings) {
        this.context = context;
        this.ints = ints;
        this.strings = strings;
    }

    @Override
    public int getCount() {
        return ints.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.listview_drawer_menu, viewGroup, false);

        ImageView imageView = view1.findViewById(R.id.imvIcon);
        imageView.setImageResource(ints[i]);

        TextView textView = view1.findViewById(R.id.txtTitle);
        textView.setText(strings[i]);

        return view1;
    }
}
