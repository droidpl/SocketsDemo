package com.mobgen.sockets.demo.activities;

import com.mobgen.sockets.demo.R;
import com.mobgen.sockets.demo.presenters.board.BoardViewTranslator;
import com.mobgen.sockets.demo.presenters.board.SocketBoardPresenter;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;


public class BoardActivity extends PresenterActivity<SocketBoardPresenter> implements BoardViewTranslator {

	private View mReceivedView;

	@Override
	public void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.board_layout);
		mReceivedView = findViewById(R.id.received);
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
		if(mReceivedView != null) {
			mReceivedView.setAlpha(1);
			mReceivedView.setBackgroundColor(Color.RED);
			ObjectAnimator anim = ObjectAnimator.ofFloat(mReceivedView, "alpha", 1f, 0f);
			anim.setDuration(1000);
			anim.start();
		}
	}

	@Override
	public void resultsObtained () {
		//TODO results have arrived.
	}
}
