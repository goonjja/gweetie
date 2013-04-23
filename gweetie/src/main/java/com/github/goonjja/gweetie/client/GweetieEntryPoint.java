package com.github.goonjja.gweetie.client;

import com.github.goonjja.gweetie.client.mvp4g.AppRootEventBus;
import com.github.goonjja.gweetie.client.util.JSUtils;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.Mvp4gModule;

/**
 * Default entry point for applications
 * 
 * @author vedernikov
 * @date 21.09.2012
 */
public abstract class GweetieEntryPoint implements EntryPoint {
	@Override
	public void onModuleLoad() {
		GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {

			@Override
			public void onUncaughtException(Throwable e) {
				GWT.log("Uncaught exception:", e);
			}
		});
		startApplication();
	}

	protected final void startApplication() {
		Mvp4gModule module = (Mvp4gModule) GWT.create(Mvp4gModule.class);
		module.createAndStartModule();

		// init layout if not initialized before (load header, etc)
		((AppRootEventBus) module.getEventBus()).initializeNavigation();
		((AppRootEventBus) module.getEventBus()).initializeApplication();

		// load start view (Layout)
		RootPanel.get().add((Widget) module.getStartView());

		/*
		 * hide loading indicator
		 */
		Document.get().getElementById("loading").removeFromParent();
		JSUtils.initPopovers();
		JSUtils.initTooltips();
	}
}
