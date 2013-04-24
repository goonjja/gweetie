package com.github.goonjja.gweetie.client.mvp4g;

import com.github.goonjja.gweetie.client.core.MessageType;
import com.github.goonjja.gweetie.client.mvp4g.navigation.GweetiePlace;
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
public interface ChildModuleEventBus extends EventBusWithLookup {
	@Event(forwardToParent = true)
	void navigated(GweetiePlace place);

	@Event(forwardToParent = true)
	void setView(Widget newBody);

	@Event(forwardToParent = true)
	void showMessage(MessageType type, String message);

	@Event(forwardToParent = true)
	void hideMessages();

	@Event(forwardToParent = true)
	void lockScreen();

	@Event(forwardToParent = true)
	void unlockScreen();
}
