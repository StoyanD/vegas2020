package com.coiniverse.views;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.omada.prevent.coach.R;

/**
 * Created by stoyan on 10/17/14.
 */
public class MessageListView extends LinearLayout {
    /**
     * Tag for logging
     */
    private static final String TAG = "MessageListView";

    private TextView mMessage;

    private LinearLayout mLayout;

    /**
     * @param context
     */
    public MessageListView(Context context) {
        super(context);
        init(null);
    }

    /**
     * @param context
     * @param attrs
     */
    public MessageListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyle
     */
    public MessageListView(Context context, AttributeSet attrs, int defStyle) {
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
        final LinearLayout mainV = (LinearLayout) inflater.inflate(R.layout.view_message_list_item, this);
        mLayout = mainV;
        mMessage = (TextView) mainV.findViewById(R.id.message_text);
    }


    public void setColor(int text, int background){
        mMessage.setTextColor(text);
        mLayout.setBackgroundColor(background);
    }
    public void setMessageText(String text){
        Resources res = getResources();
        mMessage.setText(text);
    }
}