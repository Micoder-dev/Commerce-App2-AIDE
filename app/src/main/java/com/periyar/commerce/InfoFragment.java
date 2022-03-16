package com.periyar.commerce;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class InfoFragment extends Fragment implements GoogleApiClient.OnConnectionFailedListener {

    private CircleImageView profile_settings1;
    private TextView profile_name1;
    private TextView profile_email1;
    private Button logout_btn;
    private GoogleApiClient googleApiClient;
    private GoogleSignInOptions gso;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_info, container, false);

        profile_settings1=view.findViewById(R.id.profile_settings1);
        profile_name1=view.findViewById(R.id.profile_name1);
        profile_email1=view.findViewById(R.id.profile_email1);
        logout_btn=view.findViewById(R.id.logout_btn);

        gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();

        googleApiClient=new GoogleApiClient.Builder(getActivity())
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso).build();

        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alert=new AlertDialog.Builder(getContext());
                alert.setMessage("Are you sure want to Logout!")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
                                    @Override
                                    public void onResult(@NonNull Status status) {
                                        if (status.isSuccess()) {
                                            gotoGoogleLogin();
                                            Toast.makeText(getContext(),
                                                    "Logouted...",
                                                    Toast.LENGTH_LONG)
                                                    .show();
                                        }
                                        else {
                                            Toast.makeText(getActivity(), "Logout error!", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
            }
        });


        return view;
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
    private void gotoGoogleLogin() {

        startActivity(new Intent(getActivity(),GoogleLogin.class));
        getActivity().finish();
    }
    private void handleSignInResult (GoogleSignInResult result){
        if (result.isSuccess()){
            GoogleSignInAccount account=result.getSignInAccount();
            profile_name1.setText(account.getDisplayName());
            profile_email1.setText(account.getEmail());
            Picasso.get().load(account.getPhotoUrl()).placeholder(R.drawable.icon).into(profile_settings1);
        }else {
            gotoGoogleLogin();
        }
    }
    @Override
    public void onStart() {
        super.onStart();

        googleApiClient.connect();

        OptionalPendingResult<GoogleSignInResult> opr=Auth.GoogleSignInApi.silentSignIn(googleApiClient);
        if (opr.isDone()){
            GoogleSignInResult result=opr.get();
            handleSignInResult(result);
        }else {
            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                @Override
                public void onResult(@NonNull GoogleSignInResult result) {
                    handleSignInResult(result);
                }
            });
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        googleApiClient.disconnect();
    }
}
