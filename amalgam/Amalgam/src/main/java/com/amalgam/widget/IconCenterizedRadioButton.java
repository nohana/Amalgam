package com.amalgam.widget;

import com.amalgam.R;
import com.amalgam.view.ViewUtils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.RelativeLayout;
import android.widget.TextView;

@SuppressWarnings("unused") // public APIs
public class IconCenterizedRadioButton extends CompoundRelativeLayout {
    private static final int DEFAULT_TEXT_SIZE = 15;

    public IconCenterizedRadioButton(Context context) {
        this(context, null);
    }

    public IconCenterizedRadioButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public IconCenterizedRadioButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.IconCenterizedRadioButton, defStyle, 0);

        setClickable(true);

        TextView textView = new TextView(context);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT , RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(CENTER_IN_PARENT, TRUE);
        textView.setGravity(Gravity.CENTER);
        textView.setDuplicateParentStateEnabled(true);
        textView.setText(a.getText(R.styleable.IconCenterizedRadioButton_text));
        textView.setTextSize(ViewUtils.pixelToSip(context, a.getDimensionPixelSize(R.styleable.IconCenterizedRadioButton_textSize, DEFAULT_TEXT_SIZE)));
        ColorStateList textColor = a.getColorStateList(R.styleable.IconCenterizedRadioButton_textColor);
        textView.setTextColor(textColor == null ?  ColorStateList.valueOf(0xFF000000) : textColor);
        textView.setCompoundDrawablesWithIntrinsicBounds(null, a.getDrawable(R.styleable.IconCenterizedRadioButton_iconDrawable), null, null);
        textView.setCompoundDrawablePadding((int) a.getDimension(R.styleable.IconCenterizedRadioButton_iconDrawablePadding, 0));
        textView.setLayoutParams(params);
        addView(textView);

        a.recycle();
    }

    @Override
    public void toggle() {
        // we override to prevent toggle when the radio is already
        // checked (as opposed to check boxes widgets)
        if (!isChecked()) {
            super.toggle();
        }
    }
}