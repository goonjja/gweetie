package com.github.goonjja.gweetie.core.handlers;

import com.github.goonjja.gweetie.core.GweetieRootEventBus;
import com.github.goonjja.gweetie.core.util.JSUtils;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.EventHandler;
import com.mvp4g.client.event.BaseEventHandler;

/**
 * Reinitializes tooltips after new view has been loaded.
 * 
 * @author vedernikov
 * @date 25.04.2013
 */
@EventHandler
public class UtilHandler extends BaseEventHandler<GweetieRootEventBus> implements ViewManager {

	@Override
	public void onLoadView(LayoutPlace place, Widget view) {
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				JSUtils.initPopovers();
				JSUtils.initTooltips();
			}
		});
	}
}
