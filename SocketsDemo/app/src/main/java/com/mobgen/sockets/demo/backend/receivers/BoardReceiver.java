package com.mobgen.sockets.demo.backend.receivers;

import com.mobgen.sockets.demo.backend.model.Board;

/**
 * Created by javierdepedrolopez on 25/05/15.
 */
public interface BoardReceiver {
	void receiveBoard(Board board);
}
