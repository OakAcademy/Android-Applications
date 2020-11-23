package com.ongel.informationbook.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ongel.informationbook.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class FragmentItaly extends Fragment {

    public static FragmentItaly newInstance()
    {
        return new FragmentItaly();
    }

    private ImageView imageViewItaly;
    private ProgressBar progressBarItaly;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_italy,container,false);

        imageViewItaly = view.findViewById(R.id.imageViewItaly);
        progressBarItaly = view.findViewById(R.id.progressBarItaly);

        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/0/03/" +
                "Flag_of_Italy.svg/1024px-Flag_of_Italy.svg.png")
                .into(imageViewItaly, new Callback() {
                    @Override
                    public void onSuccess() {

                        progressBarItaly.setVisibility(View.INVISIBLE);

                    }

                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(getActivity(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                        progressBarItaly.setVisibility(View.INVISIBLE);
                    }
                });

        return view;
    }
}
