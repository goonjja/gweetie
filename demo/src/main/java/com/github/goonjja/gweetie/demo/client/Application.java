package com.github.goonjja.gweetie.demo.client;

import com.github.goonjja.gweetie.core.GweetieEntryPoint;
import com.github.goonjja.gweetie.demo.client.core.AppEventBus;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.RootPanel;

public class Application extends GweetieEntryPoint<AppEventBus> {

	@Override
	protected HasWidgets getRoot() {
		return RootPanel.get();
	}

	@Override
	protected void postStart(AppEventBus eventBus) {
		// hide loading indicator
		Document.get().getElementById("loading").removeFromParent();
		eventBus.loadHeader();
	}

}
