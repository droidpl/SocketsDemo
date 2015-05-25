package com.mobgen.sockets.demo.backend.emitters;

import com.mobgen.sockets.demo.backend.model.Player;
import com.mobgen.sockets.demo.backend.receivers.PlayerReceiver;

import org.json.JSONObject;

/**
 * Created by javierdepedrolopez on 25/05/15.
 */
public class PlayerEmitter extends UIEmitter<Player> {
	private PlayerReceiver mReceiver;

	public PlayerEmitter(PlayerReceiver receiver){
		mReceiver = receiver;
	}

	@Override
	public void uiEmit (Player data) {
		mReceiver.receivePlayer(data);
	}

	@Override
	public Player parse (JSONObject json) {
		return new Player();
	}
}
