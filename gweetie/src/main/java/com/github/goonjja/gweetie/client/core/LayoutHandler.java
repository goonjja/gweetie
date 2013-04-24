package com.github.goonjja.gweetie.client.core;

import com.github.goonjja.gweetie.client.mvp4g.RootModuleEventBus;
import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.EventHandler;
import com.mvp4g.client.event.EventHandlerInterface;

@EventHandler
public interface LayoutHandler extends EventHandlerInterface<RootModuleEventBus> {
	
	public void onSetHeader(Widget header);

	public void onSetView(Widget newBody);
}
