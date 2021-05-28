package com.fishque.coitocare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

public class MatchMainFragment extends Fragment {

    private SwitchCompat swCondom, swPep, swPrep;
    private TextView tvProtection;
    private boolean mCondom = false;
    private boolean mPep = false;
    private boolean mPrep = false;

    public MatchMainFragment() {
        super(R.layout.fragment_match_main);
        // Empty constructor
    }

    public static  MatchMainFragment newInstance() {
        return new MatchMainFragment();
    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {

        View root = super.onCreateView(inflater, container, savedInstanceState);

        if (root != null) {

            swCondom = root.findViewById(R.id.match_protection_condom_switch);
            swPep = root.findViewById(R.id.match_protection_pep_switch);
            swPrep = root.findViewById(R.id.match_protection_prep_switch);
            tvProtection = root.findViewById(R.id.match_protection_state);

            swCondom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    mCondom = isChecked;
                    setProtectionStateText();

                }
            });
            swPep.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    mPep = isChecked;
                    setProtectionStateText();

                }
            });
            swPrep.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    mPrep = isChecked;
                    setProtectionStateText();

                }
            });

            setProtectionStateText();
            Button btnMakeMatch = root.findViewById(R.id.match_make);
            btnMakeMatch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Bundle bundle = new Bundle();
                    bundle.putBoolean(CoitoConsts.KEY_PROTECTION_CONDOM, mCondom);
                    bundle.putBoolean(CoitoConsts.KEY_PROTECTION_PEP, mPep);
                    bundle.putBoolean(CoitoConsts.KEY_PROTECTION_PREP, mPrep);
                    getParentFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.match_fragment_container, MatchQrFragment.newInstance(bundle), null)
                    .commitNow();

                }
            });

        }

        return root;
    }

    void setProtectionStateText() {

        if (mCondom || mPep || mPrep) {
            tvProtection.setText(R.string.match_main_protection_yes);
        } else {
            tvProtection.setText(R.string.match_main_protection_no);
        }

    }


}
