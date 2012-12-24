package me.goonjja.gwt.scrim.client.presenters;

import me.goonjja.gwt.scrim.client.mvp4g.AppEventBus;
import me.goonjja.gwt.scrim.client.mvp4g.navigation.AppPlace;
import me.goonjja.gwt.scrim.client.views.Header;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view = Header.class)
public class HeaderPresenter extends BasePresenter<Header, AppEventBus> {
	private boolean headerInitialized = false;
	private String applicationName = "";

	public void onStart() {
	}

	/**
	 * Called when application is started in client's browser
	 */
	public void onInitializeApplication(String applicationName) {
		if (headerInitialized)
			return;
		headerInitialized = true;
		view.getHeadAnchor().setText(applicationName);
		eventBus.setHeader(view);
	}

	public void onBeforeChildModuleLoaded() {
		onInitializeApplication(applicationName);
	}

	public void onNavigated(AppPlace place) {
	}
}