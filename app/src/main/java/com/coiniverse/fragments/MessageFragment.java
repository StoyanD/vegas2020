package com.coiniverse.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.omada.prevent.coach.R;
import com.coiniverse.adapters.MessageAdapter;

/**
 * Created by stoyan on 10/17/14.
 */
public class MessageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View fragV = inflater.inflate(R.layout.fragment_message, container, false);
        ListView list = (ListView)fragV.findViewById(R.id.message_list);
        list.setAdapter(new MessageAdapter(getActivity()));
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

}
