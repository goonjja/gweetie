package com.github.goonjja.gweetie.demo.client;

import com.github.goonjja.gweetie.client.core.ApplicationInitializer;
import com.github.goonjja.gweetie.client.core.ChildModuleLoadingHandler;
import com.github.goonjja.gweetie.client.core.LayoutHandler;
import com.github.goonjja.gweetie.client.core.MessageHandler;
import com.github.goonjja.gweetie.client.core.NavigationHandler;
import com.github.goonjja.gweetie.client.core.UiLockHandler;
import com.github.goonjja.gweetie.client.mvp4g.GweetieGinModule;
import com.github.goonjja.gweetie.client.mvp4g.navigation.PlacesProvider;
import com.github.goonjja.gweetie.client.presenters.DefaultHeaderPresenter;
import com.github.goonjja.gweetie.client.presenters.DefaultLayoutPresenter;

public class GinModule extends GweetieGinModule {
	@Override
	protected Class<? extends PlacesProvider> getPlacesProviderClass() {
		return NavigationPlacesProvider.class;
	}

	@Override
	protected Class<? extends MessageHandler> getMessageHandler() {
		return DefaultLayoutPresenter.class;
	}

	@Override
	protected Class<? extends ApplicationInitializer> getApplicationInitializer() {
		return Initializer.class;
	}

	@Override
	protected Class<? extends ChildModuleLoadingHandler> getChildModuleLoadingHandler() {
		return DefaultHeaderPresenter.class;
	}

	@Override
	protected Class<? extends NavigationHandler> getNavigationHandler() {
		return DefaultLayoutPresenter.class;
	}

	@Override
	protected Class<? extends UiLockHandler> getUiLockHandler() {
		return DefaultLayoutPresenter.class;
	}

	@Override
	protected Class<? extends LayoutHandler> getLayoutHandler() {
		return DefaultLayoutPresenter.class;
	}

}
