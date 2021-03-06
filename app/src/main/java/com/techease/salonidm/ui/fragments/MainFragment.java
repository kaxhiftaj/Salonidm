package com.techease.salonidm.ui.fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.techease.salonidm.R;
import com.techease.salonidm.ui.activities.FullScreenActivity;
import com.techease.salonidm.ui.activities.SplashActivity;
import com.techease.salonidm.utils.Configuration;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainFragment extends Fragment {


    @BindView(R.id.appointment)
    ImageButton appointment;

    @BindView(R.id.my_client)
    ImageButton my_client;

    @BindView(R.id.business_info)
    ImageButton business_info;

    @BindView(R.id.business_hr)
    ImageButton business_hr;

    @BindView(R.id.service)
    ImageButton service;

    @BindView(R.id.business_setting)
    ImageButton business_setting;

    @BindView(R.id.promotions)
    ImageButton discounts;

    @BindView(R.id.commission)
    ImageButton commission;

    @BindView(R.id.portfolio)
    ImageButton portfolio;

    Unbinder unbinder;
    Typeface typeface;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, v);
        customActionBar();
        sharedPreferences = getActivity().getSharedPreferences(Configuration.MY_PREF, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        typeface= Typeface.createFromAsset(getActivity().getAssets(),"Fonts/Montserrat-Medium.otf");

        
        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new ServicesFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack("view").commit();
            }
        });

        business_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new BusinessInfo();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack("view").commit();
            }
        });


        business_hr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new BusinessHoursFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack("view").commit();
            }
        });


        appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new AppointmentsFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack("view").commit();
            }
        });

        commission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new ComissionsFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack("view").commit();
            }
        });


        discounts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new DiscountFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack("view").commit();
            }
        });

        portfolio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new PortfolioFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack("view").commit();
            }
        });


        my_client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new MyClients();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            }
        });

        business_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new BusinessFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack("view").commit();
            }
        });
        return v;
    }


    public void customActionBar() {
        android.support.v7.app.ActionBar mActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(getActivity());
        View mCustomView = mInflater.inflate(R.layout.custom_actionbar, null);
        TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.title_text);
        mTitleTextView.setTypeface(typeface);
        ImageView backbutton = (ImageView) mCustomView.findViewById(R.id.back);
        ImageButton logout = (ImageButton) mCustomView.findViewById(R.id.logout);
        logout.setVisibility(View.VISIBLE);
        backbutton.setVisibility(View.GONE);
        mTitleTextView.setText("FOR SALON PROFESSIONALS");
        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.clear().commit();
                startActivity(new Intent(getActivity(), SplashActivity.class));
            }
        });

    }

}
