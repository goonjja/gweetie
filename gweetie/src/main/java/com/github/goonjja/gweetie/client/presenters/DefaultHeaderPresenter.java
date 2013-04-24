package com.github.goonjja.gweetie.client.presenters;

import javax.inject.Singleton;

import com.github.goonjja.gweetie.client.FrameworkUIMessages;
import com.github.goonjja.gweetie.client.core.ChildModuleLoadingHandler;
import com.github.goonjja.gweetie.client.core.MessageType;
import com.github.goonjja.gweetie.client.mvp4g.RootModuleEventBus;
import com.github.goonjja.gweetie.client.views.Header;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Singleton
@Presenter(view = Header.class)
public class DefaultHeaderPresenter extends BasePresenter<Header, RootModuleEventBus> implements
		ChildModuleLoadingHandler {
	private boolean headerInitialized = false;

	/**
	 * Called when application is started in client's browser
	 */
	public void onLoadHeader() {
		if (headerInitialized)
			return;
		headerInitialized = true;
		eventBus.setHeader(view);
	}

	public void onBeforeChildModuleLoaded() {
		onLoadHeader();
	}

	@Override
	public void onErrorOnLoadChildModule(Throwable reason) {
		eventBus.showMessage(MessageType.ERROR,
				FrameworkUIMessages.INSTANCE.childModuleLoadingError() + " " + reason.getMessage());
	}
}