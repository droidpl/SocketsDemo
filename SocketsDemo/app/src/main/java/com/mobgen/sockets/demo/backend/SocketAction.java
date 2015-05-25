package com.mobgen.sockets.demo.backend;

/**
 * Created by javierdepedrolopez on 25/05/15.
 */
public enum SocketAction {
	PLAYER_ACTION("player::action");

	private String mAction;

	SocketAction(String action){
		mAction = action;
	}

	public String getAction(){
		return mAction;
	}
}
