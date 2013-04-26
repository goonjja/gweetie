package com.github.goonjja.gweetie.demo.client.core;

import com.github.goonjja.gweetie.core.GweetieRootEventBus;
import com.github.goonjja.gweetie.core.navigation.GweetiePlaceService;
import com.github.goonjja.gweetie.core.util.Mvp4gLogger;
import com.github.goonjja.gweetie.demo.client.presenters.HeaderPresenter;
import com.github.goonjja.gweetie.demo.client.presenters.LayoutPresenter;
import com.github.goonjja.gweetie.demo.client.presenters.MainpagePresenter;
import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Debug;
import com.mvp4g.client.annotation.Debug.LogLevel;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.PlaceService;
import com.mvp4g.client.annotation.module.ChildModule;
import com.mvp4g.client.annotation.module.ChildModules;
import com.mvp4g.client.annotation.module.DisplayChildModuleView;

@Events(startPresenter = LayoutPresenter.class, historyOnStart = true, ginModules = GinModule.class)
@PlaceService(GweetiePlaceService.class)
@Debug(logger = Mvp4gLogger.class, logLevel = LogLevel.DETAILED)
@ChildModules({ @ChildModule(moduleClass = DashboardModule.class) })
public interface AppEventBus extends GweetieRootEventBus {

	@Event(handlers = HeaderPresenter.class)
	void loadHeader();
	
	@Event(handlers = MainpagePresenter.class)
	void mainpage();

	@Event(handlers = LayoutPresenter.class)
	void showNotification(String title, String message);

	@Event(handlers = LayoutPresenter.class)
	void showProcessing(String title, String message);

	@Event(handlers = LayoutPresenter.class)
	void hideProcessing();
	
	@Event(forwardToModules = DashboardModule.class)
	void dashboard();
	
	@Event(handlers = LayoutPresenter.class)
	@DisplayChildModuleView(DashboardModule.class)
	void showDashboard(Widget dashboard);
}


