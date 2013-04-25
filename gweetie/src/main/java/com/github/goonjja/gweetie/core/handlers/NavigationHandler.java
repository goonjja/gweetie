package com.github.goonjja.gweetie.core.handlers;

import com.github.goonjja.gweetie.core.GweetieRootEventBus;
import com.github.goonjja.gweetie.core.navigation.GweetiePlace;
import com.mvp4g.client.annotation.EventHandler;
import com.mvp4g.client.event.EventHandlerInterface;

@EventHandler
public interface NavigationHandler extends EventHandlerInterface<GweetieRootEventBus> {

	void onNavigated(GweetiePlace place);

	void onPageNotFound();
}
