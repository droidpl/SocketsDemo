package demo.sockets.mobgen.com.socketsdemo.presenters.framework;

import android.util.Log;

import demo.sockets.mobgen.com.socketsdemo.backend.SocketManager;

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
