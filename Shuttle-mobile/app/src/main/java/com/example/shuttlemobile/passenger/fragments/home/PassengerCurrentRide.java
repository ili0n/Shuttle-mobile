package com.example.shuttlemobile.passenger.fragments.home;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.shuttlemobile.R;

public class PassengerCurrentRide extends Fragment {
    public static PassengerCurrentRide newInstance() {
        PassengerCurrentRide fragment = new PassengerCurrentRide();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_passenger_current_ride, container, false);
    }
}