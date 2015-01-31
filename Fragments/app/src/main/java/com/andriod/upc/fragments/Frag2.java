package com.andriod.upc.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Frag2
 */
public class Frag2 extends Fragment implements View.OnClickListener {

    OnFragmentMessage Callback;
    int i = 0;

    // Container Activity must implement this interface
    public interface OnFragmentMessage {
        public void onFragmentMessage(String message);
    }

    public Frag2() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_frag2, container, false);
        rootView.findViewById(R.id.button2).setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            Callback = (OnFragmentMessage) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " does not implement OnFragmentMessage!");
        }
    }

    @Override
    public void onClick(final View v) {
        Callback.onFragmentMessage(String.format("Hi Activity! %d", i++));
    }
}
