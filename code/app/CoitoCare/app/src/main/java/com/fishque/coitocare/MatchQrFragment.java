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

public class MatchQrFragment extends Fragment {

    private Bundle mBundle;
    private boolean protectionState = false;
    private String eventId;
    private String eventCodeString;
    private int partnerCount;
    TextView tvPartnerCount;
    Button btnDone;

    public MatchQrFragment() {
        // Required empty public constructor
    }

    public static MatchQrFragment newInstance(Bundle bundle) {
        MatchQrFragment fragment = new MatchQrFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        partnerCount = 0;
        if (getArguments() != null) {
            protectionState = getArguments().getBoolean("PROTECTION_STATE");
        }
    }

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
        QRGEncoder encoder = new QRGEncoder(eventCodeString, null, QRGContents.Type.TEXT, 1000);
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
                        .replace(R.id.match_fragment_container, MatchScanFragment.newInstance(mBundle), null)
                        .commitNow();

                // https://developer.android.com/training/camerax/analyze
                // https://developers.google.com/ml-kit/vision/barcode-scanning/android
                // https://github.com/zendroidhd/camerax-barcode-scanner/tree/development/app/src/main/java/com/technology/zenlight/barcodescanner
                // https://www.youtube.com/watch?v=i46VlSinoko

                // https://github.com/akhilbattula/android-camerax-java

                // https://developer.android.com/training/camerax

            }
        });
        updateView();
        return root;

    }

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