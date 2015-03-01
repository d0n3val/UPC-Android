package com.example.done.fragments_practica2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Imatges extends Fragment {

    View root;

    public Imatges() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_imatges, container, false);
        return root;
    }

    public void OnImageChange(int id)
    {
        ImageView img = (ImageView) root.findViewById(R.id.imageView);
        switch(id)
        {
            case 1:
                img.setBackgroundResource(R.drawable.red);
                break;
            case 2:
                img.setBackgroundResource(R.drawable.yellow);
                break;
            case 3:
                img.setBackgroundResource(R.drawable.green);
                break;
        }
    }

}
