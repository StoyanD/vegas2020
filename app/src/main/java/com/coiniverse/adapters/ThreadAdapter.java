package com.coiniverse.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.omada.prevent.coach.R;
import com.coiniverse.views.ThreadListView;

/**
 * Created by stoyan on 10/17/14.
 */
public class ThreadAdapter extends BaseAdapter{
    /**
     * Tag for logging
     */
    private static final String TAG = "ThreadAdapter";
    /**
     * The context of the calling activity
     */
    private Context mContext;

    /**
     * Fake faces for the event list for now
     */
    public Integer[] mThumbIds = {
            R.drawable.f_1, R.drawable.f_2,
            R.drawable.f_3, R.drawable.f_4,
            R.drawable.f_5, R.drawable.f_6,
            R.drawable.f_7, R.drawable.f_8,
            R.drawable.f_9, R.drawable.f_10,
            R.drawable.f_11, R.drawable.f_12,
            R.drawable.f_13, R.drawable.f_14,
            R.drawable.f_1, R.drawable.f_2,
            R.drawable.f_3, R.drawable.f_4,
            R.drawable.f_5, R.drawable.f_6,
            R.drawable.f_7, R.drawable.f_8,
            R.drawable.f_9, R.drawable.f_10,
            R.drawable.f_11, R.drawable.f_12,
            R.drawable.f_13, R.drawable.f_14
    };

    public ThreadAdapter(Context context) {
        this.mContext = context;
    }
    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int i) {
        return mThumbIds[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view != null){
            ((ThreadListView)view).setFakePicId(mThumbIds[i], i);
            return view;
        }

        ThreadListView peep = new ThreadListView(mContext);
//        Log.i(TAG,"Setting fake pic id to :  " +  mThumbIds[i]);
        peep.setFakePicId(mThumbIds[i], i);
        return peep;
    }
}
