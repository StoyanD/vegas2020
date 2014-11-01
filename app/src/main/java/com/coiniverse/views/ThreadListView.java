package com.coiniverse.views;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.omada.prevent.coach.R;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * Created by stoyan on 5/15/14.
 */
public class ThreadListView extends LinearLayout {
    /**
     * Tag for logging
     */
    private static final String TAG = "ExpandableEventListView";

    private ImageView mProfilePic;
    private TextView mName;
    private TextView mSentDate;
    private TextView mMessage;

    /**
     * @param context
     */
    public ThreadListView(Context context) {
        super(context);
        init(null);
    }

    /**
     * @param context
     * @param attrs
     */
    public ThreadListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyle
     */
    public ThreadListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    /**
     * Initiate the views from the xml
     * @param attrs Any custom attributes passed to the gauge_seekbar_view.xml
     */
    private void init(AttributeSet attrs) {
        if (attrs != null) {

        }

        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LinearLayout mainV = (LinearLayout) inflater.inflate(R.layout.view_thread_list_item, this);
        mProfilePic = (ImageView) mainV.findViewById(R.id.fake_profile_pic);
        mName = (TextView) mainV.findViewById(R.id.participant_name);
        mSentDate = (TextView) mainV.findViewById(R.id.thread_message_date);
        mMessage = (TextView) mainV.findViewById(R.id.thread_last_message_blurp);
    }



    public void setFakePicId(int id, int pos){
        Resources res = getResources();
        Random rand = new Random();
        DecimalFormat form = new DecimalFormat("0.0");
        int low = 3;
        int high = 6;

        mProfilePic.setImageDrawable(res.getDrawable(id));
        mName.setText(res.getStringArray(R.array.thread_titles)[pos%15]);
        mMessage.setText(res.getStringArray(R.array.messages)[pos%10]);
        mSentDate.setText("Oct " + (rand.nextInt(24) + 1));
        int max_spots = rand.nextInt(50) + 1;
    }
}
