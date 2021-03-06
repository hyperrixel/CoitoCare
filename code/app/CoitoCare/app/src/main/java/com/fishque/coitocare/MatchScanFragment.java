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
 * This file contains MatchScanFragment class code.
 */

package com.fishque.coitocare;

import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.mlkit.vision.barcode.Barcode;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.common.InputImage;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Provide screen to scan and process QR codes
 * ===========================================
 */
public class MatchScanFragment extends Fragment {

    private Bundle mBundle;

    private Executor executor = Executors.newSingleThreadExecutor();

    PreviewView mPreviewView;
    Button mButton;

    /**
     * Construct object instance
     * -------------------------
     */
    public MatchScanFragment() {

        // Required empty public constructor

    }

    /**
     * Create a new instance
     * ---------------------
     *
     * @param   Bundle bundle
     *          Instance information.
     * @return  MatchScanFragment
     *          The created new instance.
     */
    public static MatchScanFragment newInstance(Bundle bundle) {

        MatchScanFragment fragment = new MatchScanFragment();
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

        View root = inflater.inflate(R.layout.fragment_match_scan, container, false);
        mBundle = savedInstanceState;
        mPreviewView = root.findViewById(R.id.qr_camera);
        mButton = root.findViewById(R.id.scan_qr_code);

        if (arePermissionsGranted()) {

            useCamera();

        } else {

            if (getActivity() != null) {

                ActivityCompat.requestPermissions(getActivity(),
                        CoitoConsts.QR_SCAN_REQUIRED_PERMISSIONS,
                        CoitoConsts.QR_REQUEST_CODE_PERMISSION);

            }

        }

        return root;

    }

    /**
     * Check whether permissions are granted or not
     * --------------------------------------------
     *
     * @return  boolean
     *          True if permission is granted, false if not.
     */
    private boolean arePermissionsGranted() {

        for (String permission : CoitoConsts.QR_SCAN_REQUIRED_PERMISSIONS) {

            if (getContext() != null) {

                if (ContextCompat.checkSelfPermission(getContext(), permission) !=
                        PackageManager.PERMISSION_GRANTED) {

                    return false;

                }

            }

        }

        return true;

    }

    /**
     * Bind camera view
     * ----------------
     *
     * @param   ProcessCameraProvider provider
     *          Provider to process the pictures of the camera.
     */
    private void bindView(@NonNull ProcessCameraProvider provider) {

        if (getActivity() != null) {

            Preview preview = new Preview.Builder().build();
            CameraSelector cameraSelector = new CameraSelector.Builder()
                    .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                    .build();
            ImageAnalysis imageAnalysis = new ImageAnalysis.Builder().build();
            ImageCapture.Builder builder = new ImageCapture.Builder();
            final ImageCapture imageCapture = builder
                    .setTargetRotation(getActivity().getWindowManager()
                            .getDefaultDisplay().getRotation())
                    .build();

            preview.setSurfaceProvider(mPreviewView.getSurfaceProvider());

            Camera camera = provider.bindToLifecycle(this, cameraSelector, preview,
                    imageAnalysis, imageCapture);

            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    imageCapture.takePicture(executor, new ImageCapture.OnImageCapturedCallback() {
                        @Override
                        public void onCaptureSuccess(@NonNull @NotNull ImageProxy imageProxy) {

                            super.onCaptureSuccess(imageProxy);

                            BarcodeScannerOptions options = new BarcodeScannerOptions.Builder()
                                    .setBarcodeFormats(Barcode.FORMAT_QR_CODE)
                                    .build();
                            @SuppressLint("UnsafeOptInUsageError")
                            Image mayNullImage = imageProxy.getImage();
                            if (mayNullImage != null) {

                                InputImage image = InputImage.fromMediaImage(mayNullImage,
                                        imageProxy.getImageInfo().getRotationDegrees());
                                BarcodeScanner scanner = BarcodeScanning.getClient(options);
                                Task<List<Barcode>> result = scanner.process(image)
                                        .addOnSuccessListener(new OnSuccessListener<List<Barcode>>() {
                                            @Override
                                            public void onSuccess(@NonNull @NotNull List<Barcode> barcodes) {

                                                for (Barcode barcode : barcodes) {

                                                    Rect bounds = barcode.getBoundingBox();
                                                    Point[] corners = barcode.getCornerPoints();
                                                    String raw = barcode.getRawValue();

                                                    int codeType = barcode.getValueType();

                                                    if (codeType == Barcode.TYPE_TEXT && raw != null) {

                                                        if (raw.contains(CoitoConsts.getQrHeader())) {

                                                            CoitoConsts.counter += 1;
                                                            int count = 0;

                                                            if (mBundle != null) {

                                                                if (mBundle.containsKey(CoitoConsts
                                                                        .KEY_NEW_PARTNER_COUNT)) {
                                                                    count = mBundle.getInt(CoitoConsts
                                                                            .KEY_NEW_PARTNER_COUNT);
                                                                }

                                                            } else {

                                                                mBundle = new Bundle();

                                                            }
                                                            mBundle.putInt(CoitoConsts
                                                                    .KEY_NEW_PARTNER_COUNT, count);
                                                            count += 1;
                                                            getParentFragmentManager().beginTransaction()
                                                                    .setReorderingAllowed(true)
                                                                    .replace(R.id.match_fragment_container,
                                                                            MatchQrFragment.newInstance(mBundle))
                                                                    .commitNow();

                                                        }

                                                    }

                                                }

                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull @NotNull Exception e) {

                                                Toast toast = Toast.makeText(getActivity(),
                                                        "Failure", Toast.LENGTH_SHORT);
                                                toast.show();

                                            }
                                        });

                            }

                        }
                    });

                }
            });

        }

    }

    /**
     * Manage the use of the camera
     * ----------------------------
     */
    private void useCamera() {

        if (getContext() != null) {

            final ListenableFuture<ProcessCameraProvider> cameraProvider =
                    ProcessCameraProvider.getInstance(getContext());

            cameraProvider.addListener(new Runnable() {
                @Override
                public void run() {

                    ProcessCameraProvider processCameraProvider = null;
                    try {

                        processCameraProvider = cameraProvider.get();
                        bindView(processCameraProvider);

                    } catch (ExecutionException | InterruptedException e) {

                        Toast toast = Toast.makeText(getContext(), e.toString(), Toast.LENGTH_LONG);
                        toast.show();

                    }

                }
            }, ContextCompat.getMainExecutor(getContext()));

        }

    }

}