package com.example.done.fragments_practica2;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class LlistaImatges extends Fragment implements View.OnClickListener {

    OnMessage Callback;

    public LlistaImatges() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_llista_imatges, container, false);
        v.findViewById(R.id.imageButton1).setOnClickListener(this);
        v.findViewById(R.id.imageButton2).setOnClickListener(this);
        v.findViewById(R.id.imageButton3).setOnClickListener(this);
        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            Callback = (OnMessage) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " does not implement OnMessage!");
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id)
        {
            case R.id.imageButton1:
                Callback.OnImageChanged(1);
                break;
            case R.id.imageButton2:
                Callback.OnImageChanged(2);
                break;
            case R.id.imageButton3:
                Callback.OnImageChanged(3);
                break;
        }
    }
}
