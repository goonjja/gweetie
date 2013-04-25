package com.github.goonjja.gweetie.core.handlers;

import com.github.goonjja.gweetie.core.GweetieRootEventBus;
import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.EventHandler;
import com.mvp4g.client.event.EventHandlerInterface;

@EventHandler
public interface ViewManager extends EventHandlerInterface<GweetieRootEventBus> {

	public void onLoadView(LayoutPlace place, Widget view);
}
