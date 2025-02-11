package com.actionbarsherlock.app;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.Watson.OnCreateOptionsMenuListener;
import android.support.v4.app.Watson.OnOptionsItemSelectedListener;
import android.support.v4.app.Watson.OnPrepareOptionsMenuListener;

import com.actionbarsherlock.internal.view.menu.MenuItemWrapper;
import com.actionbarsherlock.internal.view.menu.MenuWrapper;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

public class SherlockFragment extends Fragment implements
		OnCreateOptionsMenuListener, OnPrepareOptionsMenuListener,
		OnOptionsItemSelectedListener {
	private SherlockFragmentActivity mActivity;

	public SherlockFragmentActivity getSherlockActivity() {
		return mActivity;
	}

	@Override
	public void onAttach(Activity activity) {
		if (!(activity instanceof SherlockFragmentActivity)) {
			throw new IllegalStateException(getClass().getSimpleName()
					+ " must be attached to a SherlockFragmentActivity.");
		}
		mActivity = (SherlockFragmentActivity) activity;

		super.onAttach(activity);
	}

	@Override
	public void onDetach() {
		mActivity = null;
		super.onDetach();
	}

	@Override
	public final void onCreateOptionsMenu(android.view.Menu menu,
			android.view.MenuInflater inflater) {
		onCreateOptionsMenu(new MenuWrapper(menu),
				mActivity.getSupportMenuInflater());
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// Nothing to see here.
	}

	@Override
	public final void onPrepareOptionsMenu(android.view.Menu menu) {
		onPrepareOptionsMenu(new MenuWrapper(menu));
	}

	@Override
	public void onPrepareOptionsMenu(Menu menu) {
		// Nothing to see here.
	}

	@Override
	public final boolean onOptionsItemSelected(android.view.MenuItem item) {
		return onOptionsItemSelected(new MenuItemWrapper(item));
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Nothing to see here.
		return false;
	}
}
