package com.mobgen.sockets.demo.backend.receivers;

import com.mobgen.sockets.demo.backend.model.Player;

/**
 * Created by javierdepedrolopez on 25/05/15.
 */
public interface PlayerReceiver {
	void receivePlayer(Player player);
}
