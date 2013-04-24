package com.github.goonjja.gweetie.client.core;

import com.github.goonjja.gweetie.client.mvp4g.RootModuleEventBus;
import com.mvp4g.client.annotation.EventHandler;
import com.mvp4g.client.event.EventHandlerInterface;

@EventHandler
public interface UiLockHandler extends EventHandlerInterface<RootModuleEventBus> {
	/**
	 * Called when event bus's lockScreen event is happen. Should lock
	 * interaction with user interface until unlockScreen event happened.
	 */
	void onLockScreen();

	/**
	 * Called when event bus's unlockScreen event is happen. Should clear lock
	 * on user interface and allow interaction.
	 */
	void onUnlockScreen();
}
