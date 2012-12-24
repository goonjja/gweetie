package me.goonjja.gwt.scrim.client.mvp4g;

import me.goonjja.gwt.scrim.client.mvp4g.navigation.AppPlace;
import me.goonjja.gwt.scrim.client.mvp4g.navigation.AppPlaceService;
import me.goonjja.gwt.scrim.client.mvp4g.navigation.NavigationEventHandler;
import me.goonjja.gwt.scrim.client.presenters.ApplicationErrorPresenter;
import me.goonjja.gwt.scrim.client.presenters.ApplicationSuccessPresenter;
import me.goonjja.gwt.scrim.client.presenters.ForbiddenPresenter;
import me.goonjja.gwt.scrim.client.presenters.HeaderPresenter;
import me.goonjja.gwt.scrim.client.presenters.LayoutPresenter;
import me.goonjja.gwt.scrim.client.views.Header;

import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.InitHistory;
import com.mvp4g.client.annotation.NotFoundHistory;
import com.mvp4g.client.annotation.PlaceService;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.annotation.module.BeforeLoadChildModule;
import com.mvp4g.client.annotation.module.LoadChildModuleError;
import com.mvp4g.client.event.EventBusWithLookup;

/**
 * Base interface for all event buses in app. Created to simplify usage of
 * common events for all mvp4g modules.
 * 
 * @author Ведерников Сергей
 * 
 */
@PlaceService(AppPlaceService.class)
public interface AppEventBus extends EventBusWithLookup {

	/*
	 * Simple presenter method that will be called on event
	 */
	public static final String ON_LOAD = "onLoad";

	/*
	 * Called when token is not specified
	 */
	@Start
	@InitHistory
	@Event(handlers = { LayoutPresenter.class, HeaderPresenter.class })
	void start();

	@Event(handlers = { HeaderPresenter.class, LayoutPresenter.class })
	void navigated(AppPlace place);

	/*
	 * Initialization of application layout
	 */
	@Event(handlers = { NavigationEventHandler.class, HeaderPresenter.class })
	void initializeApplication(String applicationName);

	/*
	 * Called when token is invalid
	 */
	@NotFoundHistory
	@Event(handlers = LayoutPresenter.class)
	public void pageNotFound();

	@Event(handlers = LayoutPresenter.class)
	void setHeader(Header header);

	@Event(handlers = LayoutPresenter.class)
	void setView(Widget newBody);

	// for child modules inheritance
	@Event(handlers = LayoutPresenter.class, calledMethod = "onSetView")
	void setViewForwarded(Widget newBody);

	@Event(handlers = LayoutPresenter.class)
	void showProcessing(String title, String message);

	@Event(handlers = LayoutPresenter.class)
	void hideProcessing();

	@Event(handlers = LayoutPresenter.class)
	void showError(String message);

	@Event(handlers = LayoutPresenter.class)
	void showSuccess(String message);

	@Event(handlers = LayoutPresenter.class)
	void hideAlerts();

	/*
	 * System events
	 */
	@Event(handlers = ApplicationErrorPresenter.class, calledMethod = ON_LOAD)
	void applicationError(String message);

	@Event(handlers = ApplicationSuccessPresenter.class, calledMethod = ON_LOAD)
	void applicationSuccess(String title, String text);

	@Event(handlers = ForbiddenPresenter.class, calledMethod = ON_LOAD)
	void forbidden(Throwable cause);

	@LoadChildModuleError
	@Event(handlers = LayoutPresenter.class)
	void errorOnLoad(Throwable reason);

	@BeforeLoadChildModule
	@Event(handlers = HeaderPresenter.class)
	void beforeChildModuleLoaded();
}
