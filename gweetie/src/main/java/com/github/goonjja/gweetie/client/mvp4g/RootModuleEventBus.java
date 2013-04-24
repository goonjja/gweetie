package com.github.goonjja.gweetie.client.mvp4g;

import com.github.goonjja.gweetie.client.core.ApplicationInitializer;
import com.github.goonjja.gweetie.client.core.ChildModuleLoadingHandler;
import com.github.goonjja.gweetie.client.core.LayoutHandler;
import com.github.goonjja.gweetie.client.core.MessageHandler;
import com.github.goonjja.gweetie.client.core.MessageType;
import com.github.goonjja.gweetie.client.core.NavigationHandler;
import com.github.goonjja.gweetie.client.core.UiLockHandler;
import com.github.goonjja.gweetie.client.mvp4g.navigation.GweetiePlace;
import com.github.goonjja.gweetie.client.mvp4g.navigation.HistoryChangeHandler;
import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.InitHistory;
import com.mvp4g.client.annotation.NotFoundHistory;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.annotation.module.BeforeLoadChildModule;
import com.mvp4g.client.annotation.module.LoadChildModuleError;

/**
 * Base interface for all event buses in app. Created to simplify usage of
 * common events for all mvp4g modules.
 * 
 * <b>You must add following annotations:</b> <br/>
 * &#64;Events(startPresenter = LayoutPresenter.class, historyOnStart = true,
 * ginModules = &lt;YOUR_GIN_MODULE&gt;.class)<br/>
 * &#64;PlaceService(AppPlaceService.class)<br/>
 * 
 * @author Ведерников Сергей
 * 
 */
public interface RootModuleEventBus extends ChildModuleEventBus {

	@Start
	@Event(handlers = ApplicationInitializer.class)
	void start();

	/*
	 * Called when token is not specified
	 */
	@InitHistory
	@Event(handlers = ApplicationInitializer.class)
	void emptyHistoryToken();

	@Event(handlers = ApplicationInitializer.class)
	void initializeApplication();

	@Event(handlers = NavigationHandler.class)
	void navigated(GweetiePlace place);

	@NotFoundHistory
	@Event(handlers = NavigationHandler.class)
	public void pageNotFound();

	@Event(handlers = HistoryChangeHandler.class)
	void initializeHistoryChangeHandler();

	@LoadChildModuleError
	@Event(handlers = ChildModuleLoadingHandler.class)
	void errorOnLoadChildModule(Throwable reason);

	@BeforeLoadChildModule
	@Event(handlers = ChildModuleLoadingHandler.class)
	void beforeChildModuleLoaded();

	/* Layout control */
	@Event(handlers = LayoutHandler.class)
	void setHeader(Widget header);

	@Event(handlers = LayoutHandler.class)
	void setView(Widget newBody);

	/* Messages, Locking */
	@Event(handlers = MessageHandler.class)
	void showMessage(MessageType type, String message);

	@Event(handlers = MessageHandler.class)
	void hideMessages();

	@Event(handlers = UiLockHandler.class)
	void lockScreen();

	@Event(handlers = UiLockHandler.class)
	void unlockScreen();
}
