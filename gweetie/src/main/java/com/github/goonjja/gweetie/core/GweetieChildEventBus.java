package com.github.goonjja.gweetie.core;

import com.github.goonjja.gweetie.core.handlers.LayoutPlace;
import com.github.goonjja.gweetie.core.handlers.MessageType;
import com.github.goonjja.gweetie.core.navigation.GweetiePlace;
import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.event.EventBusWithLookup;

/**
 * Base interface for all event buses in app. Created to simplify usage of
 * common events for all mvp4g modules.
 * 
 * @author Ведерников Сергей
 * 
 */
public interface GweetieChildEventBus extends EventBusWithLookup {
	@Event(forwardToParent = true)
	void navigated(GweetiePlace place);

	@Event(forwardToParent = true)
	void loadView(LayoutPlace place, Widget view);

	@Event(forwardToParent = true)
	void showMessage(MessageType type, String message);

	@Event(forwardToParent = true)
	void hideMessages();
}
