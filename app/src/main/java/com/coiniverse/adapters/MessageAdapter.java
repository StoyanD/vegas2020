package com.coiniverse.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.omada.prevent.coach.R;
import com.coiniverse.views.MessageListView;

/**
 * Created by stoyan on 10/17/14.
 */
public class MessageAdapter extends BaseAdapter {
    /**
     * Tag for logging
     */
    private static final String TAG = "ThreadAdapter";
    /**
     * The context of the calling activity
     */
    private Context mContext;

    /**
     * Fake messages for the message list for now
     */
    public String[] mMessages;

    public MessageAdapter(Context context) {
        this.mContext = context;
        mMessages = mContext.getResources().getStringArray(R.array.messages);
    }


    @Override
    public int getCount() {
        return mMessages.length;
    }

    @Override
    public Object getItem(int i) {
        return mMessages[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MessageListView peep = (MessageListView) view;
        int text = R.color.white;
        int back = R.color.message_teal_green;
        if(i%2 == 0 ){
            text = R.color.black;
            back = R.color.message_gray;
        }
        if(view != null){
            peep.setMessageText(mMessages[i]);
            peep.setColor(text, back);
            return view;
        }

        peep = new MessageListView(mContext);
        peep.setMessageText(mMessages[i]);
        peep.setColor(text, back);
        return peep;
    }
}
