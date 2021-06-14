/**
 * CoitoCare
 * =========
 * Complete solution for sexually active people to provide safety from
 * sexually transmitted disease or infection.
 *
 * @author     Axel Ország-Krisz Dr.
 * @author     Richárd Ádám Vécsey Dr.
 *
 * @copyright  (c) 2021 by Axel Ország-Krisz Dr. and Richárd Ádám Vécsey Dr.
 * @copyright  All rights reserved.
 * @copyright  ATTENTION: This code is not open source.
 *
 * This file contains DiseaseFragment class code.
 */

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

/**
 * Provide disease management screen
 * =================================
 */
public class DiseaseFragment extends Fragment {

    Spinner spState;
    TextView tvState;

    /**
     * Construct object instance
     * -------------------------
     */
    public DiseaseFragment() {

        // Required empty public constructor

    }

    /**
     * Create a new instance
     * ---------------------
     *
     * @return  DiseaseFragment
     *          The created new instance.
     */
    public static DiseaseFragment newInstance() {

        return new DiseaseFragment();

    }

    /**
     * Handle creation of the object
     * -----------------------------
     *
     * @param   Bundle savedInstanceState
     *          Instance information.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    /**
     * Handle the creation of the fragment's view
     * ------------------------------------------
     *
     * @param   LayoutInflater inflater
     *          The inflater to use to inflate the layout.
     * @param   ViewGroup container
     *          The container to inflate the boject to.
     * @param   Bundle savedInstanceState
     *          Instance information.
     *
     * @return  View
     *          The created view.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_disease, container, false);
        spState = root.findViewById(R.id.disease_disease_spinner);
        tvState = root.findViewById(R.id.disease_state_text);
        spState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("StringFormatMatches")
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                tvState.setText(String.format(getString(R.string.disease_yes,
                        spState.getSelectedItem().toString())));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tvState.setText(getText(R.string.disease_no));
            }
        });
        tvState.setText(getText(R.string.disease_no));
        return root;

    }

}