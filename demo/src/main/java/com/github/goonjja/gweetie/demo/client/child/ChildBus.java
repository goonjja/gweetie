package com.github.goonjja.gweetie.demo.client.child;

import com.github.goonjja.gweetie.core.GweetieChildEventBus;
import com.github.goonjja.gweetie.core.navigation.GweetieHistoryConverter;
import com.github.goonjja.gweetie.core.util.Mvp4gLogger;
import com.github.goonjja.gweetie.demo.client.GinModule;
import com.github.goonjja.gweetie.demo.client.navigation.Places;
import com.mvp4g.client.annotation.Debug;
import com.mvp4g.client.annotation.Debug.LogLevel;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.module.ChildModule;
import com.mvp4g.client.annotation.module.ChildModules;

@ChildModules(@ChildModule(moduleClass = SubModule2.class, async = true, autoDisplay = false))
@Events(startPresenter = ChildPresenter.class, module = SubModule.class, ginModules = GinModule.class)
@Debug(logger = Mvp4gLogger.class, logLevel = LogLevel.DETAILED)
public interface ChildBus extends GweetieChildEventBus {

	@Event(
			handlers = ChildPresenter.class,
			navigationEvent = true,
			historyConverter = GweetieHistoryConverter.class,
			name = Places.Names.CHILD_ROOT_PLACE)
	void showChild();

	@Event(forwardToModules = SubModule2.class)
	void goToView2(String param);
}
