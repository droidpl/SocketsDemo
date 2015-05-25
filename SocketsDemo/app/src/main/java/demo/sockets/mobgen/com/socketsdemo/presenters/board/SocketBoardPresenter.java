package demo.sockets.mobgen.com.socketsdemo.presenters.board;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import demo.sockets.mobgen.com.socketsdemo.presenters.framework.SocketPresenter;

/**
 * Created by javierdepedrolopez on 25/05/15.
 */
public class SocketBoardPresenter extends SocketPresenter {

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
		//TODO add the game listeners
	}
}
