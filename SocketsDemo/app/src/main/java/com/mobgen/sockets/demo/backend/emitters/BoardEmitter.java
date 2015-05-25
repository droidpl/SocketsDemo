package com.mobgen.sockets.demo.backend.emitters;

import com.mobgen.sockets.demo.backend.model.Board;
import com.mobgen.sockets.demo.backend.receivers.BoardReceiver;

import org.json.JSONObject;

/**
 * Created by javierdepedrolopez on 25/05/15.
 */
public class BoardEmitter extends UIEmitter<Board>{

	private BoardReceiver mReceiver;

	public BoardEmitter(BoardReceiver receiver){
		mReceiver = receiver;
	}

	@Override
	public void uiEmit (Board data) {
		mReceiver.receiveBoard(data);
	}

	@Override
	public Board parse (JSONObject json) {
		//TODO parse json
		return new Board();
	}
}
