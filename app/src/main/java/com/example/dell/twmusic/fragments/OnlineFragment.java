package com.example.dell.twmusic.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.twmusic.R;

/**
 * Created by DELL on 8/14/2016.
 */
public class OnlineFragment extends Fragment{
    public OnlineFragment() {

    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmentonline,container,false);
    }
}
