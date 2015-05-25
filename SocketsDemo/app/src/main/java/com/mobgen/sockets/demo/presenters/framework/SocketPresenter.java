package com.mobgen.sockets.demo.presenters.framework;

import com.mobgen.sockets.demo.backend.SocketManager;

import android.util.Log;

/**
 * Created by javierdepedrolopez on 25/05/15.
 */
public abstract class SocketPresenter implements Presenter{
	@Override
	public void tearDown () {
		SocketManager.get().disconnect();
		Log.d(getClass().getSimpleName(), "teardown presenter");
	}

	@Override
	public void paused () {
		SocketManager.get().disconnect();
		Log.d(getClass().getSimpleName(), "paused presenter");
	}

	@Override
	public void resumed () {
		SocketManager.get().connect();
		attachObservers();
		Log.d(getClass().getSimpleName(), "resumed presenter");
	}
}
