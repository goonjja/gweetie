package com.github.goonjja.gweetie.demo.client;

import com.github.goonjja.gweetie.client.core.ApplicationInitializer;
import com.mvp4g.client.annotation.EventHandler;

@EventHandler
public class Initializer extends ApplicationInitializer {
	@Override
	public void onInitializeApplication() {
		((AppEventBus)eventBus).loadHeader();
		((AppEventBus)eventBus).showChild();
	}
}
