package me.goonjja.gwt.scrim.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import me.goonjja.gwt.scrim.client.mvp4g.AppEventBus;
import me.goonjja.gwt.scrim.client.util.JSUtils;

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
public abstract class AppEntryPoint implements EntryPoint {

	Logger log = Logger.getLogger("Scrim");

	@Override
	public void onModuleLoad() {
		GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {

			@Override
			public void onUncaughtException(Throwable e) {
				log.log(Level.SEVERE, "Uncaught exception:", e);
			}
		});
		initializeApplication();
	}

	private void initializeApplication() {
		Mvp4gModule module = (Mvp4gModule) GWT.create(Mvp4gModule.class);
		module.createAndStartModule();

		// init layout if not initialized before (load header, etc)
		((AppEventBus) module.getEventBus()).initializeApplication(getApplicationName());
		((AppEventBus) module.getEventBus()).dispatch(getApplicationStartEventName());

		// load start view (Layout)
		RootPanel.get().add((Widget) module.getStartView());

		/*
		 * hide loading indicator
		 */
		Document.get().getElementById("loading").removeFromParent();
		JSUtils.initPopovers();
		JSUtils.initTooltips();
	}

	protected abstract String getApplicationName();

	protected abstract String getApplicationStartEventName();
}
