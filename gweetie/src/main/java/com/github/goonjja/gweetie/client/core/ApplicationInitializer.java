package com.github.goonjja.gweetie.client.core;

import com.github.goonjja.gweetie.client.mvp4g.RootModuleEventBus;
import com.mvp4g.client.annotation.EventHandler;
import com.mvp4g.client.event.BaseEventHandler;

@EventHandler
public abstract class ApplicationInitializer extends BaseEventHandler<RootModuleEventBus> {

	boolean applicationInitialized = false;

	public void onStart() {
		// init history change handler
		eventBus.initializeHistoryChangeHandler();

		if (!applicationInitialized)
			eventBus.initializeApplication();
		applicationInitialized = true;
	}

	public void onEmptyHistoryToken() {
		// do nothing, everything is done by event bus and navigation handlers
	}

	public abstract void onInitializeApplication();
}
