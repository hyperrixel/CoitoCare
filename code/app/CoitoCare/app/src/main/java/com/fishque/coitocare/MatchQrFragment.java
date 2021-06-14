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
 * This file contains MatchQrFragment class code.
 */

package com.fishque.coitocare;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

/**
 * Provide QR code generator and match registration screen
 * =======================================================
 */
public class MatchQrFragment extends Fragment {

    private Bundle mBundle;
    private boolean protectionState = false;
    private String eventId;
    private String eventCodeString;
    private int partnerCount;
    TextView tvPartnerCount;
    Button btnDone;

    /**
     * Construct object instance
     * -------------------------
     */
    public MatchQrFragment() {
        // Required empty public constructor
    }

    /**
     * Create a new instance
     * ---------------------
     *
     * @param   Bundle bundle
     *          Instance information.
     * @return  MatchQrFragment
     *          The created new instance.
     */
    public static MatchQrFragment newInstance(Bundle bundle) {
        MatchQrFragment fragment = new MatchQrFragment();
        fragment.setArguments(bundle);
        return fragment;
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
        partnerCount = 0;
        if (getArguments() != null) {
            protectionState = getArguments().getBoolean("PROTECTION_STATE");
        }
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

        View root = inflater.inflate(R.layout.fragment_match_qr, container, false);
        mBundle = savedInstanceState;
        partnerCount = 0;
        if (mBundle != null) {

            if (mBundle.containsKey(CoitoConsts.KEY_NEW_PARTNER_COUNT)) {
                partnerCount = mBundle.getInt(CoitoConsts.KEY_NEW_PARTNER_COUNT);
            }

        }
        eventId = CoitoTools.generateEventCode();
        eventCodeString = CoitoConsts.getQrHeader() + eventId;
        QRGEncoder encoder = new QRGEncoder(eventCodeString, null,
                QRGContents.Type.TEXT, 1000);
        tvPartnerCount = root.findViewById(R.id.partner_count);
        btnDone = root.findViewById(R.id.match_done);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mainIntent = new Intent(getActivity(), MainActivity.class);

                startActivity(mainIntent);
            }
        });

        try {

            Bitmap bitmap = encoder.encodeAsBitmap();
            ImageView imageView = root.findViewById(R.id.event_qr_code);
            imageView.setImageBitmap(bitmap);

        } catch (WriterException exception) {

            Toast toast = Toast.makeText(root.getContext(),
                    exception.toString(),
                    Toast.LENGTH_LONG );
            toast.show();

        }

        Button btnAdd = root.findViewById(R.id.match_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getParentFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.match_fragment_container,
                                MatchScanFragment.newInstance(mBundle), null)
                        .commitNow();

            }
        });
        updateView();
        return root;

    }

    /**
     * Perform the update of the view
     * ------------------------------
     */
    void updateView() {

        if (CoitoConsts.counter == 0) {

            tvPartnerCount.setText(getString(R.string.match_qr_no_partner));
            btnDone.setEnabled(false);

        } else {

            tvPartnerCount.setText(String.format(getString(R.string.match_qr_partner_count),
                    CoitoConsts.counter));
            btnDone.setEnabled(true);

        }

    }

}