package com.github.goonjja.gweetie.demo.client.child;

import com.github.goonjja.gweetie.core.GweetieChildEventBus;
import com.github.goonjja.gweetie.core.navigation.GweetieHistoryConverter;
import com.github.goonjja.gweetie.core.util.Mvp4gLogger;
import com.github.goonjja.gweetie.demo.client.GinModule;
import com.github.goonjja.gweetie.demo.client.navigation.Places;
import com.mvp4g.client.annotation.Debug;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.Debug.LogLevel;

@Events(startPresenter = SecondPresenter.class, module = SubModule2.class, ginModules = GinModule.class)
@Debug(logger = Mvp4gLogger.class, logLevel = LogLevel.DETAILED)
public interface ChildBus2 extends GweetieChildEventBus{
	@Event(
			handlers = SecondPresenter.class,
			navigationEvent = true,
			historyConverter = GweetieHistoryConverter.class,
			name = Places.Names.CHILD_VIEW2_PLACE)
	void goToView2(String param);
}
