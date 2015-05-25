package com.mobgen.sockets.demo.backend.emitters;

import com.github.nkzawa.emitter.Emitter;

import org.json.JSONObject;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by javierdepedrolopez on 25/05/15.
 */
public abstract class UIEmitter<T> implements Emitter.Listener {

	@Override
	public void call (Object... args) {
		final T data = parse((JSONObject) args[args.length - 1]);
		new Handler(Looper.getMainLooper()).post(new Runnable(){
			@Override
			public void run () {
				uiEmit(data);
			}
		});
	}

	public abstract void uiEmit(T data);
	public abstract T parse(JSONObject json);
}
