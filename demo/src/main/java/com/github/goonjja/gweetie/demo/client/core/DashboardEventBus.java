package com.github.goonjja.gweetie.demo.client.core;

import com.github.goonjja.gweetie.core.GweetieChildEventBus;
import com.github.goonjja.gweetie.core.handlers.LayoutPlace;
import com.github.goonjja.gweetie.core.navigation.GweetieHistoryConverter;
import com.github.goonjja.gweetie.demo.client.presenters.dashboard.DashboardPresenter;
import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.module.ChildModule;
import com.mvp4g.client.annotation.module.ChildModules;
import com.mvp4g.client.annotation.module.DisplayChildModuleView;

@Events(module = DashboardModule.class, startPresenter = DashboardPresenter.class, ginModules = GinModule.class)
// @Debug(logger = Mvp4gLogger.class, logLevel = LogLevel.DETAILED)
@ChildModules({ @ChildModule(moduleClass = DeeperModule.class) })
public interface DashboardEventBus extends GweetieChildEventBus {
	@Event(
			name = DashboardModule.MAIN_PAGE,
			navigationEvent = true,
			historyConverter = GweetieHistoryConverter.class,
			handlers = DashboardPresenter.class)
	void dashboard();

	@Event(handlers = DashboardPresenter.class)
	@DisplayChildModuleView(DeeperModule.class)
	void showDeeper(Widget deeper);

	@Override
	@Event(handlers = DashboardPresenter.class)
	void loadView(LayoutPlace place, Widget view);

	@Event(forwardToModules = DeeperModule.class)
	void deeper();
}
