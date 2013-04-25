package com.github.goonjja.gweetie.core.handlers;

import com.github.goonjja.gweetie.core.GweetieRootEventBus;
import com.mvp4g.client.annotation.EventHandler;
import com.mvp4g.client.event.EventHandlerInterface;


@EventHandler
public interface MessageHandler extends EventHandlerInterface<GweetieRootEventBus> {
	void onShowMessage(MessageType type, String message);

	void onHideMessages();
}
