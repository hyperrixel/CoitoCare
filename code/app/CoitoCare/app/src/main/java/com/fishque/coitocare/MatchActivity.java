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
 * This file contains MatchActivity class code.
 */

package com.fishque.coitocare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * Provide creation of a match event
 * =================================
 */
public class MatchActivity extends AppCompatActivity {

    /**
     * Handle creation of the object
     * -----------------------------
     *
     * @param   Bundle savedInstanceState
     *          Instance information.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        setContentView(R.layout.activity_match);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.match_fragment_container, MatchMainFragment.newInstance(), null)
                    .commitNow();
        }

    }

}