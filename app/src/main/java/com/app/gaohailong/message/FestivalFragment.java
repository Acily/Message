package com.app.gaohailong.message;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

/**
 * Created by donglinghao on 2015-10-10.
 */
public class FestivalFragment extends Fragment{
    private GridView mGridView;
    private ArrayAdapter<Festival> mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.festival_sms,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mGridView = (GridView) view.findViewById(R.id.id_grid_view);
        mAdapter = new ArrayAdapter<Festival>(getActivity(),-1,FestivalLab.getInstance().getFestivals()){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null){
                    convertView = LayoutInflater.from(getActivity()).inflate(R.layout.festival_item,parent,false);
                }
                TextView tv = (TextView) convertView.findViewById(R.id.id_text_view);
                tv.setText(getItem(position).getName());
                return convertView;
            }
        };
        mGridView.setAdapter(mAdapter);
    }
}
