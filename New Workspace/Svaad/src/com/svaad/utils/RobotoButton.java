package com.svaad.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

public class RobotoButton extends Button{
	public RobotoButton(Context context) {
        super(context);
        style(context);
    }

    public RobotoButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        style(context);
    }

    public RobotoButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        style(context);
    }

    private void style(Context context) {
        Typeface tf = Typeface.createFromAsset(context.getAssets(),
                "fonts/Roboto-Light.ttf");
        setTypeface(tf);
    }

}
