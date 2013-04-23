package com.github.goonjja.gweetie.client.mvp4g;

import com.github.goonjja.gweetie.client.mvp4g.navigation.NavigationEventHandler;
import com.github.goonjja.gweetie.client.presenters.HeaderPresenter;
import com.github.goonjja.gweetie.client.presenters.LayoutPresenter;
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
 * <b>You must add following annotations:</b>
 * <br/>
 * &#64;Events(startPresenter = LayoutPresenter.class, historyOnStart = true, ginModules = &lt;YOUR_GIN_MODULE&gt;.class)<br/>
 * &#64;PlaceService(AppPlaceService.class)<br/>
 * @author Ведерников Сергей
 * 
 */
public interface AppRootEventBus extends AppEventBus {

	void initializeApplication();

	/*
	 * Called when token is not specified
	 */
	@Start
	@InitHistory
	@Event(handlers = { LayoutPresenter.class, HeaderPresenter.class })
	void start();

	/*
	 * Initialization of application navigation handler
	 */
	@Event(handlers = NavigationEventHandler.class)
	void initializeNavigation();

	@NotFoundHistory
	@Event(handlers = LayoutPresenter.class)
	public void pageNotFound();

	@LoadChildModuleError
	@Event(handlers = LayoutPresenter.class)
	void errorOnLoad(Throwable reason);

	@BeforeLoadChildModule
	@Event(handlers = HeaderPresenter.class)
	void beforeChildModuleLoaded();
}
