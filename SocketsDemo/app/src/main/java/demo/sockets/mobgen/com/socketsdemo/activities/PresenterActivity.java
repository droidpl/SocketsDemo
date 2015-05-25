package demo.sockets.mobgen.com.socketsdemo.activities;

import android.app.Activity;
import android.os.Bundle;

import demo.sockets.mobgen.com.socketsdemo.presenters.framework.Presenter;

/**
 * Created by javierdepedrolopez on 25/05/15.
 */
public abstract class PresenterActivity <T extends Presenter> extends Activity {

	protected T mPresenter;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mPresenter = createPresenter();
		mPresenter.initialize(savedInstanceState);
	}

	@Override
	protected void onPause () {
		super.onPause();
		mPresenter.paused();
	}

	@Override
	protected void onResume () {
		super.onResume();
		mPresenter.resumed();
	}

	@Override
	protected void onDestroy () {
		super.onDestroy();
		mPresenter.tearDown();
	}

	public abstract T createPresenter();
}
