package com.mobgen.sockets.demo.presenters.board;

import com.mobgen.sockets.demo.backend.SocketManager;
import com.mobgen.sockets.demo.backend.SocketSend;
import com.mobgen.sockets.demo.backend.emitters.BoardEmitter;
import com.mobgen.sockets.demo.backend.emitters.PlayerEmitter;
import com.mobgen.sockets.demo.backend.model.Board;
import com.mobgen.sockets.demo.backend.model.Player;
import com.mobgen.sockets.demo.backend.receivers.BoardReceiver;
import com.mobgen.sockets.demo.backend.receivers.PlayerReceiver;
import com.mobgen.sockets.demo.presenters.framework.SocketPresenter;
import android.os.Bundle;
import android.util.Log;


/**
 * Created by javierdepedrolopez on 25/05/15.
 */
public class SocketBoardPresenter extends SocketPresenter implements BoardReceiver, PlayerReceiver {

	private BoardViewTranslator mTranslator;

	public SocketBoardPresenter(BoardViewTranslator translator){
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
	public void receiveBoard (Board board) {
		mTranslator.startTurn();
		Log.i(getClass().getSimpleName(), board.toString());
	}

	@Override
	public void receivePlayer (Player player) {
		Log.i(getClass().getSimpleName(), player.toString());
	}
}
