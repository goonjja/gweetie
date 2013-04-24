package com.github.goonjja.gweetie.demo.client.child;

import com.github.goonjja.gweetie.client.mvp4g.ChildModuleEventBus;
import com.github.goonjja.gweetie.client.mvp4g.navigation.GweetieHistoryConverter;
import com.github.goonjja.gweetie.client.util.Mvp4gLogger;
import com.github.goonjja.gweetie.demo.client.GinModule;
import com.github.goonjja.gweetie.demo.client.Places;
import com.mvp4g.client.annotation.Debug;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.Debug.LogLevel;

@Events(startPresenter = ChildPresenter.class, module = ChildModule.class, ginModules = GinModule.class)
@Debug(logger = Mvp4gLogger.class, logLevel = LogLevel.DETAILED)
public interface ChildBus extends ChildModuleEventBus {

	@Event(
			handlers = ChildPresenter.class,
			navigationEvent = true,
			historyConverter = GweetieHistoryConverter.class,
			name = Places.Names.CHILD_ROOT_PLACE)
	void showChild();
}
