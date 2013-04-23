package com.github.goonjja.gweetie.demo.client;

import com.github.goonjja.gweetie.client.mvp4g.AppRootEventBus;
import com.github.goonjja.gweetie.client.mvp4g.navigation.AppPlace;
import com.github.goonjja.gweetie.client.mvp4g.navigation.AppPlaceService;
import com.github.goonjja.gweetie.client.presenters.HeaderPresenter;
import com.github.goonjja.gweetie.client.presenters.LayoutPresenter;
import com.github.goonjja.gweetie.client.util.Mvp4gLogger;
import com.mvp4g.client.annotation.Debug;
import com.mvp4g.client.annotation.Debug.LogLevel;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.InitHistory;
import com.mvp4g.client.annotation.PlaceService;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.annotation.module.BeforeLoadChildModule;

@Events(startPresenter = LayoutPresenter.class, historyOnStart = true, ginModules = GinModule.class)
@PlaceService(AppPlaceService.class)
@Debug(logger = Mvp4gLogger.class, logLevel = LogLevel.DETAILED)
public interface AppEventBus extends AppRootEventBus {

	@Start
	@InitHistory
	@Event(handlers = { HeaderPresenter.class, LayoutPresenter.class, ApplicationInitializer.class })
	void start();

	@Event(handlers = { HeaderPresenter.class })
	void initializeApplication();

	@Event(handlers = { HeaderPresenter.class, LayoutPresenter.class })
	void navigated(AppPlace place);

	@BeforeLoadChildModule
	@Event(handlers = HeaderPresenter.class)
	void beforeChildModuleLoaded();
}
