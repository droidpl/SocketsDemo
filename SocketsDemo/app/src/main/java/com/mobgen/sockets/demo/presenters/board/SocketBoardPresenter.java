package com.mobgen.sockets.demo.presenters.board;

import com.mobgen.sockets.demo.backend.SocketManager;
import com.mobgen.sockets.demo.backend.SocketSend;
import com.mobgen.sockets.demo.backend.emitters.BoardEmitter;
import com.mobgen.sockets.demo.backend.emitters.PlayerEmitter;
import com.mobgen.sockets.demo.backend.receivers.BoardReceiver;
import com.mobgen.sockets.demo.backend.receivers.PlayerReceiver;
import com.mobgen.sockets.demo.presenters.framework.SocketPresenter;

import org.json.JSONObject;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;


/**
 * Created by javierdepedrolopez on 25/05/15.
 */
public class SocketBoardPresenter extends SocketPresenter implements BoardReceiver, PlayerReceiver {

	private Context mContext;
	private BoardViewTranslator mTranslator;

	public SocketBoardPresenter(Context ctx, BoardViewTranslator translator){
		mContext = ctx;
		mTranslator = translator;
	}

	@Override
	public void initialize (Bundle savedInstanceState) {
		mTranslator.startGame();
	}

	@Override
	public void attachObservers () {
		Log.d(getClass().getSimpleName(), "attaching presenter listeners");
		SocketManager manager = SocketManager.get();
		manager.on(SocketSend.BOARD_SEND, new BoardEmitter(this));
		manager.on(SocketSend.PLAYER_SEND, new PlayerEmitter(this));
	}

	@Override
	public void receiveBoard (JSONObject board) {
		new Handler(Looper.getMainLooper()).post(new Runnable() {
			@Override
			public void run () {
				mTranslator.startTurn();
			}
		});
		Log.i(getClass().getSimpleName(), board.toString());
	}

	@Override
	public void receivePlayer (JSONObject player) {
		Log.i(getClass().getSimpleName(), player.toString());
	}
}
