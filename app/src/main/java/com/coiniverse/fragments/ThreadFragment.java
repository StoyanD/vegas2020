package com.coiniverse.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.omada.prevent.coach.R;
import com.coiniverse.adapters.ThreadAdapter;
import com.coiniverse.interfaces.FragBack;

/**
 * Created by stoyan on 10/17/14.
 */
public class ThreadFragment extends Fragment {
    private FragBack callback;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View fragV = inflater.inflate(R.layout.fragment_thread, container, false);
        ListView list = (ListView)fragV.findViewById(R.id.thread_list);
        list.setAdapter(new ThreadAdapter(getActivity()));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                callback.threadClicked(i);
            }
        });
        return fragV;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public void setCallback(FragBack cb){
        callback = cb;
    }
}
