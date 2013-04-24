package com.github.goonjja.gweetie.demo.client;

import com.github.goonjja.gweetie.client.mvp4g.RootModuleEventBus;
import com.github.goonjja.gweetie.client.mvp4g.navigation.GweetiePlaceService;
import com.github.goonjja.gweetie.client.presenters.DefaultHeaderPresenter;
import com.github.goonjja.gweetie.client.presenters.DefaultLayoutPresenter;
import com.github.goonjja.gweetie.client.util.Mvp4gLogger;
import com.github.goonjja.gweetie.demo.client.child.ChildModule;
import com.mvp4g.client.annotation.Debug;
import com.mvp4g.client.annotation.Debug.LogLevel;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.PlaceService;
import com.mvp4g.client.annotation.module.ChildModules;

@Events(startPresenter = DefaultLayoutPresenter.class, historyOnStart = true, ginModules = GinModule.class)
@PlaceService(GweetiePlaceService.class)
@ChildModules(@com.mvp4g.client.annotation.module.ChildModule(
		moduleClass = ChildModule.class,
		async = true,
		autoDisplay = false))
@Debug(logger = Mvp4gLogger.class, logLevel = LogLevel.DETAILED)
public interface AppEventBus extends RootModuleEventBus {

	@Event(handlers = DefaultHeaderPresenter.class, calledMethod = "onLoadHeader")
	void loadHeader();

	@Event(forwardToModules = ChildModule.class)
	void showChild();
}
