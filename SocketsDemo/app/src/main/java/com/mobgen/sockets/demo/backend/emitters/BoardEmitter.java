package com.mobgen.sockets.demo.backend.emitters;

import com.github.nkzawa.emitter.Emitter;
import com.mobgen.sockets.demo.backend.receivers.BoardReceiver;

import org.json.JSONObject;

/**
 * Created by javierdepedrolopez on 25/05/15.
 */
public class BoardEmitter implements Emitter.Listener{

	private BoardReceiver mReceiver;

	public BoardEmitter(BoardReceiver receiver){
		mReceiver = receiver;
	}

	@Override
	public void call (Object... args) {
		mReceiver.receiveBoard((JSONObject) args[args.length - 1]);
	}
}
