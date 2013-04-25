package com.github.goonjja.gweetie.demo.client;

import com.github.goonjja.gweetie.core.GweetieRootEventBus;
import com.github.goonjja.gweetie.core.navigation.GweetiePlaceService;
import com.github.goonjja.gweetie.core.util.Mvp4gLogger;
import com.github.goonjja.gweetie.demo.client.child.SubModule;
import com.github.goonjja.gweetie.demo.client.ui.DefaultHeaderPresenter;
import com.github.goonjja.gweetie.demo.client.ui.DefaultLayoutPresenter;
import com.mvp4g.client.annotation.Debug;
import com.mvp4g.client.annotation.Debug.LogLevel;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.PlaceService;
import com.mvp4g.client.annotation.module.ChildModule;
import com.mvp4g.client.annotation.module.ChildModules;

@Events(startPresenter = DefaultLayoutPresenter.class, historyOnStart = true, ginModules = GinModule.class)
@PlaceService(GweetiePlaceService.class)
@ChildModules(@ChildModule(moduleClass = SubModule.class, async = true, autoDisplay = false))
@Debug(logger = Mvp4gLogger.class, logLevel = LogLevel.DETAILED)
public interface AppEventBus extends GweetieRootEventBus {

	@Event(handlers = DefaultHeaderPresenter.class, calledMethod = "onLoadHeader")
	void loadHeader();

	@Event(forwardToModules = SubModule.class)
	void showChild();
}
