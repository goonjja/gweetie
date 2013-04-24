package com.github.goonjja.gweetie.client.core;

import com.github.goonjja.gweetie.client.mvp4g.RootModuleEventBus;
import com.mvp4g.client.annotation.EventHandler;
import com.mvp4g.client.event.EventHandlerInterface;


@EventHandler
public interface MessageHandler extends EventHandlerInterface<RootModuleEventBus> {
	void onShowMessage(MessageType type, String message);

	void onHideMessages();
}
