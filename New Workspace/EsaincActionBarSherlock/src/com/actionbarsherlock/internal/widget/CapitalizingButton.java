package com.actionbarsherlock.internal.widget;

import java.util.Locale;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.Button;

public class CapitalizingButton extends Button {
	private static final boolean SANS_ICE_CREAM = Build.VERSION.SDK_INT < Build.VERSION_CODES.ICE_CREAM_SANDWICH;
	private static final boolean IS_GINGERBREAD = Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD;

	private static final int[] R_styleable_Button = new int[] { android.R.attr.textAppearance };
	private static final int R_styleable_Button_textAppearance = 0;

	private static final int[] R_styleable_TextAppearance = new int[] { android.R.attr.textAllCaps };
	private static final int R_styleable_TextAppearance_textAllCaps = 0;

	private boolean mAllCaps;

	public CapitalizingButton(Context context, AttributeSet attrs) {
		super(context, attrs);

		TypedArray a = context
				.obtainStyledAttributes(attrs, R_styleable_Button);
		int ap = a.getResourceId(R_styleable_Button_textAppearance, -1);
		a.recycle();
		if (ap != -1) {
			TypedArray appearance = context.obtainStyledAttributes(ap,
					R_styleable_TextAppearance);
			if (appearance != null) {
				mAllCaps = appearance.getBoolean(
						R_styleable_TextAppearance_textAllCaps, true);
				appearance.recycle();
			}
		}
	}

	public void setTextCompat(CharSequence text) {
		if (SANS_ICE_CREAM && mAllCaps && text != null) {
			if (IS_GINGERBREAD) {
				try {
					setText(text.toString().toUpperCase(Locale.ROOT));
				} catch (NoSuchFieldError e) {
					// Some manufacturer broke Locale.ROOT. See #572.
					setText(text.toString().toUpperCase());
				}
			} else {
				setText(text.toString().toUpperCase());
			}
		} else {
			setText(text);
		}
	}
}
