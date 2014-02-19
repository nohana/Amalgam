package com.amalgam.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.RelativeLayout;

@SuppressWarnings("unused") // public APIs
public class CompoundRelativeLayout extends RelativeLayout implements Checkable {
    private static final int[] CHECKED_STATE_SET = { android.R.attr.state_checked };
    private boolean mChecked;
    private OnCheckedChangeListener mCheckedChangeListener;
    private OnCheckedChangeListener mOnCheckedChangeWidgetListener;

    public CompoundRelativeLayout(Context context) {
        this(context, null);
    }

    public CompoundRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CompoundRelativeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setClickable(true);
    }

    @Override
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override
    public boolean isChecked() {
        return mChecked;
    }

    @Override
    public void setChecked(boolean checked) {
        if (mChecked != checked) {
            mChecked = checked;
            refreshDrawableState();
            if (mCheckedChangeListener != null) {
                mCheckedChangeListener.onCheckedChanged(this, mChecked);
            }
            if (mOnCheckedChangeWidgetListener != null) {
                mOnCheckedChangeWidgetListener.onCheckedChanged(this, mChecked);
            }
        }
    }

    @Override
    public void toggle() {
        setChecked(!mChecked);
    }

    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        int[] state = super.onCreateDrawableState(extraSpace + 1);
        if (isChecked()) {
            mergeDrawableStates(state, CHECKED_STATE_SET);
        }
        return state;
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        mCheckedChangeListener = listener;
    }

    public static interface OnCheckedChangeListener {
        public void onCheckedChanged(CompoundRelativeLayout buttonView, boolean isChecked);
    }
}