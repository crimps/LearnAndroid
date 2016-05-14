package com.crimps.learnandroid;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/5/14.
 */
public class MargueeTextView extends TextView {
    public MargueeTextView(Context context) {
        super(context);
    }

    public MargueeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MargueeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}
