package com.github.goonjja.gweetie.core.handlers;

import com.github.goonjja.gweetie.core.GweetieRootEventBus;
import com.mvp4g.client.annotation.EventHandler;
import com.mvp4g.client.event.EventHandlerInterface;

@EventHandler
public interface ModuleLoadingHandler extends EventHandlerInterface<GweetieRootEventBus> {
	void onErrorOnLoadChildModule(Throwable reason);

	void onBeforeChildModuleLoaded();
}
