package com.github.goonjja.gweetie.demo.client;

import com.github.goonjja.gweetie.client.events.MessageType;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.mvp4g.client.annotation.EventHandler;
import com.mvp4g.client.event.BaseEventHandler;

//TODO вынести в фрэймворк как абстрактный базовый класс
@EventHandler
public class ApplicationInitializer extends BaseEventHandler<AppEventBus> {

	public void onStart() {

		Scheduler.get().scheduleFixedDelay(new RepeatingCommand() {

			@Override
			public boolean execute() {
				eventBus.showMessage(MessageType.ERROR, "Error test");
				eventBus.showMessage(MessageType.SUCCESS, "Success test");
				return false;
			}
		}, 1000);

		Scheduler.get().scheduleFixedDelay(new RepeatingCommand() {

			@Override
			public boolean execute() {
				eventBus.hideMessages();
				return false;
			}
		}, 3000);
	}
}
