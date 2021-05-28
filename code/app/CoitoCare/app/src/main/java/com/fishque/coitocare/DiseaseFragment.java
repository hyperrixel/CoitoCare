package com.fishque.coitocare;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class DiseaseFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    Spinner spState;
    TextView tvState;

    public DiseaseFragment() {
        // Required empty public constructor
    }

    public static DiseaseFragment newInstance(String param1, String param2) {
        DiseaseFragment fragment = new DiseaseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_disease, container, false);
        spState = root.findViewById(R.id.disease_disease_spinner);
        tvState = root.findViewById(R.id.disease_state_text);
        /**
        spState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("StringFormatMatches")
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                tvState.setText(String.format(getString(R.string.disease_yes, spState.getSelectedItem().toString())));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tvState.setText(getText(R.string.disease_no));
            }
        });
        **/
        tvState.setText(getText(R.string.disease_no));
        return root;
    }
}