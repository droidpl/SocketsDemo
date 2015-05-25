package com.mobgen.sockets.demo.backend.receivers;

import org.json.JSONObject;

/**
 * Created by javierdepedrolopez on 25/05/15.
 */
public interface BoardReceiver {
	void receiveBoard(JSONObject board);
}
