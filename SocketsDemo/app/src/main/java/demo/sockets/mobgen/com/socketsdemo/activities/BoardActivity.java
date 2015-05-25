package demo.sockets.mobgen.com.socketsdemo.activities;

import android.os.Bundle;
import android.os.PersistableBundle;

import demo.sockets.mobgen.com.socketsdemo.presenters.board.BoardViewTranslator;
import demo.sockets.mobgen.com.socketsdemo.presenters.board.SocketBoardPresenter;

public class BoardActivity extends PresenterActivity<SocketBoardPresenter> implements BoardViewTranslator {

	@Override
	public void onCreate (Bundle savedInstanceState, PersistableBundle persistentState) {
		super.onCreate(savedInstanceState, persistentState);

		//TODO initialize layout
	}

	@Override
	public SocketBoardPresenter createPresenter () {
		return new SocketBoardPresenter(this, this);
	}

	@Override
	public void startGame () {
		//TODO do somehting in this case.
	}

	@Override
	public void finishedTurn () {
		//TODO the turn has finished.
	}

	@Override
	public void startTurn () {
		//TODO start turn.
	}

	@Override
	public void resultsObtained () {
		//TODO results have arrived.
	}
}
