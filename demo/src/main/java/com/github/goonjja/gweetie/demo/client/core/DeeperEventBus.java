package com.github.goonjja.gweetie.demo.client.core;

import com.github.goonjja.gweetie.core.GweetieChildEventBus;
import com.github.goonjja.gweetie.core.navigation.GweetieHistoryConverter;
import com.github.goonjja.gweetie.demo.client.presenters.dashboard.deeper.DeepPagePresenter;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;

@Events(module = DeeperModule.class, ginModules = GinModule.class, startPresenter = DeepPagePresenter.class)
public interface DeeperEventBus extends GweetieChildEventBus {

	@Event(
			name = DeeperModule.MAIN_PAGE,
			navigationEvent = true,
			historyConverter = GweetieHistoryConverter.class,
			handlers = DeepPagePresenter.class)
	void deeper();
}
