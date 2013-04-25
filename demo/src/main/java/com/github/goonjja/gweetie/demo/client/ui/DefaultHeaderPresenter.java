package com.github.goonjja.gweetie.demo.client.ui;

import javax.inject.Singleton;

import com.github.goonjja.gweetie.core.GweetieRootEventBus;
import com.github.goonjja.gweetie.core.handlers.LayoutPlace;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Singleton
@Presenter(view = Header.class)
public class DefaultHeaderPresenter extends BasePresenter<Header, GweetieRootEventBus> {
	private boolean headerInitialized = false;

	/**
	 * Called when application is started in client's browser
	 */
	public void onLoadHeader() {
		if (headerInitialized)
			return;
		headerInitialized = true;
		// send not null place
		eventBus.loadView(new LayoutPlace() {
		}, view);
	}
}