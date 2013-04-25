package com.github.goonjja.gweetie.core;

import com.github.goonjja.gweetie.core.handlers.LayoutPlace;
import com.github.goonjja.gweetie.core.handlers.MessageHandler;
import com.github.goonjja.gweetie.core.handlers.MessageType;
import com.github.goonjja.gweetie.core.handlers.ModuleLoadingHandler;
import com.github.goonjja.gweetie.core.handlers.NavigationHandler;
import com.github.goonjja.gweetie.core.handlers.UtilHandler;
import com.github.goonjja.gweetie.core.handlers.ViewManager;
import com.github.goonjja.gweetie.core.navigation.GweetiePlace;
import com.github.goonjja.gweetie.core.navigation.HistoryChangeHandler;
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
public interface GweetieRootEventBus extends GweetieChildEventBus {

	@Start
	@InitHistory
	@Event(handlers = HistoryChangeHandler.class)
	void initializeHistoryChangeHandler();

	@Event(handlers = NavigationHandler.class)
	void navigated(GweetiePlace place);

	@NotFoundHistory
	@Event(handlers = NavigationHandler.class)
	public void pageNotFound();

	/* Child modules */
	@LoadChildModuleError
	@Event(handlers = ModuleLoadingHandler.class)
	void errorOnLoadChildModule(Throwable reason);

	@BeforeLoadChildModule
	@Event(handlers = ModuleLoadingHandler.class)
	void beforeChildModuleLoaded();

	/* Layout control */
	@Event(handlers = { ViewManager.class, UtilHandler.class })
	void loadView(LayoutPlace place, Widget view);

	/* Messages */
	@Event(handlers = MessageHandler.class)
	void showMessage(MessageType type, String message);

	@Event(handlers = MessageHandler.class)
	void hideMessages();
}
