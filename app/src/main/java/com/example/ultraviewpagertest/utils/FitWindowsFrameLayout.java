package com.example.ultraviewpagertest.utils;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
/**
 * @hide
 */
public class FitWindowsFrameLayout extends FrameLayout {
    public interface OnFitSystemWindowsListener {
        boolean onFitSystemWindows(Rect insets);
    }
    private OnFitSystemWindowsListener mListener;
    public FitWindowsFrameLayout(Context context) {
        super(context);
    }
    public FitWindowsFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public void setOnFitSystemWindowsListener(OnFitSystemWindowsListener listener) {
        mListener = listener;
    }
    @Override
    protected boolean fitSystemWindows(Rect insets) {
        if (mListener != null && mListener.onFitSystemWindows(insets)) {
            return true;
        }
        return super.fitSystemWindows(insets);
    }
}