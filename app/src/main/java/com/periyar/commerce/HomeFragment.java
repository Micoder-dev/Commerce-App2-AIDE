package com.periyar.commerce;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeFragment extends Fragment {

    private CardView cardSem1;
    private CardView cardSem2;
    private CardView cardSem3;
    private CardView cardSem4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home, container, false);

        cardSem1=(CardView) view.findViewById(R.id.cardSem1);
        cardSem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),Sem1.class);
                startActivity(intent);
            }
        });
        cardSem2=(CardView) view.findViewById(R.id.cardSem2);
        cardSem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),Sem2.class);
                startActivity(intent);
            }
        });
        cardSem3=(CardView) view.findViewById(R.id.cardSem3);
        cardSem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),Sem3.class);
                startActivity(intent);
            }
        });
        cardSem4=(CardView) view.findViewById(R.id.cardSem4);
        cardSem4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),Sem4.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
