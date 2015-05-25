package com.mobgen.sockets.demo.presenters.framework;

import android.os.Bundle;

/**
 * Created by javierdepedrolopez on 25/05/15.
 */
public interface Presenter {
	void initialize(Bundle savedInstanceState);
	void tearDown();
	void paused();
	void resumed();
	void attachObservers();
}
