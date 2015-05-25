package com.mobgen.sockets.demo.backend;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.mobgen.sockets.demo.BuildConfig;
import com.mobgen.sockets.demo.exceptions.SocketException;

import org.json.JSONObject;

import android.util.Log;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * The socket manager that has the current socket instance.
 */
public class SocketManager {

	/**
	 * The current socket.
	 */
	private Socket mSocket;

	/**
	 * Mantains the state of the socket.
	 */
	private boolean mIsConnected;

	/**
	 * The cache of listeners.
	 */
	private Map<String, Emitter.Listener> mCacheListeners;

	/**
	 * The board socket.
	 */
	private static SocketManager mSocketManager;

	/**
	 * Constructor of the board socket.
	 * @param socket The socket.
	 */
	private SocketManager (Socket socket){
		mSocket = socket;
		mCacheListeners = new HashMap<>();
	}

	/**
	 * Provides the current socket instance.
	 * @return The current socket instance.
	 */
	public static SocketManager get() {
		if(mSocketManager == null){
			try {
				mSocketManager = new SocketManager(IO.socket(BuildConfig.SOCKET_URL));
			} catch (URISyntaxException e) {
				throw new SocketException("The provided URL does not match the URI schema.", e);
			}
		}
		return mSocketManager;
	}

	/**
	 * Emits something to the server.
	 * @param action The action to emit.
	 * @param data The data to emit.
	 */
	public void emit(SocketAction action, JSONObject data){
		ensureConnected();
		mSocket.emit(action.getAction(), data);
	}

	/**
	 * Observes a given action.
	 * @param sendAction The action to observe.
	 * @param listener The listener for this action.
	 */
	public void on(SocketSend sendAction, Emitter.Listener listener){
		ensureConnected();
		Emitter.Listener cachedListener = mCacheListeners.get(sendAction.getAction());
		if(cachedListener != null){
			mCacheListeners.remove(sendAction.getAction());
			removeObserver(sendAction.getAction(), cachedListener);
		}
		mCacheListeners.put(sendAction.getAction(), listener);
		mSocket.on(sendAction.getAction(), listener);
	}

	/**
	 * Removes the listening from an action.
	 * @param action The action to remove.
	 */
	public void off(SocketSend action){
		Emitter.Listener listener = mCacheListeners.get(action.getAction());
		if(listener != null) {
			removeObserver(action.getAction(), mCacheListeners.get(action.getAction()));
		}else{
			Log.d(getClass().getSimpleName(), "You are doing something wrong, you are listening the same event multiple times.");
		}
	}

	/**
	 * Connects the socket to the remote service.
	 */
	public void connect(){
		if(!mIsConnected) {
			mSocket.connect();
			mIsConnected = true;
			Log.d(getClass().getSimpleName(), "Socket Manager connected");
		}
	}

	/**
	 * Closes the socket connection.
	 */
	public void disconnect (){
		if(mIsConnected) {
			mSocket.close();
			mIsConnected = false;
			Log.d(getClass().getSimpleName(), "Socket Manager closed");
			//Clear all the observers
			removeObservers();
		}
	}

	/**
	 * Removes the cached observer.
	 * @param sendAction The action to send.
	 * @param attachedListener The attached listener.
	 */
	private void removeObserver(String sendAction, Emitter.Listener attachedListener){
		mSocket.off(sendAction, attachedListener);
		Log.d(getClass().getSimpleName(), "Removed observer for " + sendAction + " action");
	}

	/**
	 * Remove all the obervers from the socket connection.
	 */
	private void removeObservers(){
		for(String key : mCacheListeners.keySet()){
			Emitter.Listener listener = mCacheListeners.get(key);
			removeObserver(key, listener);
		}
		mCacheListeners.clear();
	}

	/**
	 * Checks if the socket is connected properly.
	 */
	private void ensureConnected(){
		if(!mIsConnected) emitConnectionException();
	}

	/**
	 * Emits a connection exception produced when the socket is not opened.
	 */
	private void emitConnectionException(){
		throw new SocketException("You must be connected to emit an event.");
	}
}
