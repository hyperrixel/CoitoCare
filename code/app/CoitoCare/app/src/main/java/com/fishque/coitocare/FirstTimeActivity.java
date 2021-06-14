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
 * This file contains MainActivity class code.
 */

package com.fishque.coitocare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.fishque.coitocare.FirstTimeMainFragment;

/**
 * Provide main first time run functions
 * =====================================
 */
public class FirstTimeActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_first_time);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, FirstTimeMainFragment.newInstance())
                    .commitNow();
        }

    }

}