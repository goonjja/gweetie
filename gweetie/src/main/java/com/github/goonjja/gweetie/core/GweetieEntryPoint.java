package com.github.goonjja.gweetie.core;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.Mvp4gModule;

/**
 * Default entry point for applications
 * 
 * @author vedernikov
 * @date 21.09.2012
 */
public abstract class GweetieEntryPoint<T extends GweetieRootEventBus> implements EntryPoint {
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

	@SuppressWarnings("unchecked")
	protected final void startApplication() {
		Mvp4gModule module = (Mvp4gModule) GWT.create(Mvp4gModule.class);
		module.createAndStartModule();
		getRoot().add((Widget) module.getStartView());

		postStart((T) module.getEventBus());
	}

	protected abstract HasWidgets getRoot();

	protected abstract void postStart(T eventBus);
}
