package com.github.goonjja.gweetie.client.mvp4g;

import com.github.goonjja.gweetie.client.events.MessageHandler;
import com.github.goonjja.gweetie.client.events.MessageType;
import com.github.goonjja.gweetie.client.mvp4g.navigation.AppPlace;
import com.github.goonjja.gweetie.client.presenters.HeaderPresenter;
import com.github.goonjja.gweetie.client.presenters.LayoutPresenter;
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
public interface AppEventBus extends EventBusWithLookup {

	/*
	 * Simple presenter method that will be called on event
	 */
	public static final String ON_LOAD = "onLoad";

	@Event(handlers = { HeaderPresenter.class, LayoutPresenter.class })
	void navigated(AppPlace place);

	/*
	 * Called when token is invalid
	 */
	@Event(handlers = LayoutPresenter.class)
	void setHeader(Widget header);

	@Event(handlers = LayoutPresenter.class)
	void setView(Widget newBody);

	// for child modules inheritance
	@Event(handlers = LayoutPresenter.class, calledMethod = "onSetView")
	void setViewForwarded(Widget newBody);

	@Event(handlers = LayoutPresenter.class)
	void showProcessing(String title, String message);

	@Event(handlers = LayoutPresenter.class)
	void hideProcessing();

	@Event(handlers = MessageHandler.class)
	void showMessage(MessageType type, String message);

	@Event(handlers = MessageHandler.class)
	void hideMessages();
}
