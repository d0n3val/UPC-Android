package com.andriod.upc.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Done on 31/1/15.
 */
public class Frag1 extends Fragment {

    View rootView;
    int i = 0;

    public Frag1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        return rootView;
    }

    public void ShowMessage(String message)
    {
        TextView t = (TextView) rootView.findViewById(R.id.hello);
        if(t != null)
            t.setText(String.format("%s %d", message, i++));
    }
}