package demo.sockets.mobgen.com.socketsdemo.backend;

/**
 * Created by javierdepedrolopez on 25/05/15.
 */
public enum SocketSend {
	PLAYER_SEND("player::send"),
	BOARD_SEND("board::send");

	private String mAction;

	SocketSend(String action){
		mAction = action;
	}

	public String getAction(){
		return mAction;
	}
}
