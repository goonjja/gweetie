package com.github.goonjja.gweetie.client.events;

import com.github.goonjja.gweetie.client.mvp4g.AppEventBus;
import com.mvp4g.client.annotation.EventHandler;
import com.mvp4g.client.event.EventHandlerInterface;

@EventHandler
public interface MessageHandler extends EventHandlerInterface<AppEventBus>{
	void onShowMessage(MessageType type, String message);
	
	void onHideMessages();
}
