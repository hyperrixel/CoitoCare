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
 * This file contains SettingsFragment class code.
 */

package com.fishque.coitocare;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Provide app settings screen
 * ===========================
 */
public class SettingsFragment extends Fragment {

    /**
     * Construct object instance
     * -------------------------
     */
    public SettingsFragment() {

        // Required empty public constructor

    }

    /**
     * Create a new instance
     * ---------------------
     *
     * @return  SettingsFragment
     *          The created new instance.
     */
    public static SettingsFragment newInstance() {

        return new SettingsFragment();

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
        return inflater.inflate(R.layout.fragment_settings, container, false);

    }

}
