package srongklod_bangtamruat.plantseconomic.utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import srongklod_bangtamruat.plantseconomic.R;

public class ShowTimeLineAdapter extends BaseAdapter {

    private Context context;
    private String[] imageStrings, nameStrings, surnameStrings,
            messageStrings, showDateStrings;

    public ShowTimeLineAdapter(Context context, String[] imageStrings,
                               String[] nameStrings, String[] surnameStrings,
                               String[] messageStrings, String[] showDateStrings) {
        this.context = context;
        this.imageStrings = imageStrings;
        this.nameStrings = nameStrings;
        this.surnameStrings = surnameStrings;
        this.messageStrings = messageStrings;
        this.showDateStrings = showDateStrings;
    }

    @Override
    public int getCount() {
        return imageStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.listview_show_time_line_friend, parent, false);

        CircleImageView circleImageView = view.findViewById(R.id.cirImvIcon);
        Picasso.with(context).load(imageStrings[position]).into(circleImageView);

        TextView nameTextView = view.findViewById(R.id.txtName);
        TextView surNameTextView = view.findViewById(R.id.txtSurName);
        TextView messageTextView = view.findViewById(R.id.txtMessage);
        TextView showDateTextView = view.findViewById(R.id.txtShowDate);

        nameTextView.setText(nameStrings[position]);
        surNameTextView.setText(surnameStrings[position]);
        messageTextView.setText(messageStrings[position]);
        showDateTextView.setText(showDateStrings[position]);


        return view;
    }
}
