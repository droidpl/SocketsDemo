package com.mobgen.sockets.demo.backend.emitters;

import com.github.nkzawa.emitter.Emitter;
import com.mobgen.sockets.demo.backend.receivers.PlayerReceiver;

import org.json.JSONObject;

/**
 * Created by javierdepedrolopez on 25/05/15.
 */
public class PlayerEmitter implements Emitter.Listener {
	private PlayerReceiver mReceiver;

	public PlayerEmitter(PlayerReceiver receiver){
		mReceiver = receiver;
	}

	@Override
	public void call (Object... args) {
		mReceiver.receivePlayer((JSONObject) args[args.length - 1]);
	}
}
