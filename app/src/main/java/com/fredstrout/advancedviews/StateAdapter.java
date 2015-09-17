package com.fredstrout.advancedviews;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StateAdapter extends BaseAdapter{

    private static final int ID_Constant = 0x00010001;
    private Context sContext;
    private ArrayList<States> sStates;

    public StateAdapter(Context _c, ArrayList<States> _states) {

        sContext = _c;
        sStates = _states;
    }

    @Override
    public int getCount() {
        if (sStates == null) {
            return 0;
        }
        return sStates.size();
    }

    @Override
    public Object getItem(int position) {
        if (sStates != null && position < sStates.size() && position >= 0) {
            return sStates.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return ID_Constant + position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(sContext).inflate(R.layout.state_layout, parent, false);
        }

        States state = (States) getItem(position);

        if (state != null) {
            TextView tv = (TextView) convertView.findViewById(R.id.state_name);
            tv.setText(state.getName());

            tv = (TextView) convertView.findViewById(R.id.state_capital);
            tv.setText((state.getCapital()));
        }
        return convertView;
    }
}
