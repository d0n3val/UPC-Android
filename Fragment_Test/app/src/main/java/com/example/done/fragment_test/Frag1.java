package com.example.done.fragment_test;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag1 extends Fragment implements View.OnClickListener {

    private View rootView;
    private int i = 0;
    OnFragmentMessage Callback;

    public Frag1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_frag1, container, false);
        rootView.findViewById(R.id.button).setOnClickListener(this);
        return rootView;
    }

    public void ShowMessage(String message)
    {
        TextView t = (TextView) rootView.findViewById(R.id.text_frag1);

        if(t != null)
            t.setText(String.format("%s %d", message, i++));
    }

    @Override
    public void onClick(View v) {
        Callback.onFragmentMessage("Hi from Fragment 1");
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
}
