package demo.sockets.mobgen.com.socketsdemo.exceptions;

/**
 * Created by javierdepedrolopez on 25/05/15.
 */
public class SocketException extends RuntimeException{

	public SocketException (String message){
		super(message);
	}

	public SocketException (String message, Exception e){
		super(message, e);
	}
}
