package com.github.goonjja.gweetie.client;

import java.util.logging.Level;
import java.util.logging.Logger;

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
	private Logger log = Logger.getLogger("Gweetie");

	@Override
	public void onModuleLoad() {
		GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {

			@Override
			public void onUncaughtException(Throwable e) {
				log.log(Level.SEVERE, "Uncaught exception:", e);
			}
		});
		startApplication();
	}

	protected final void startApplication() {
		Mvp4gModule module = (Mvp4gModule) GWT.create(Mvp4gModule.class);
		module.createAndStartModule();
		RootPanel.get().add((Widget) module.getStartView());
		// hide loading indicator
		Document.get().getElementById("loading").removeFromParent();
		JSUtils.initPopovers();
		JSUtils.initTooltips();
	}
}
