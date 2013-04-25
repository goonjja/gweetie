package com.github.goonjja.gweetie.demo.client;

import com.github.goonjja.gweetie.core.GweetieGinModule;
import com.github.goonjja.gweetie.core.handlers.MessageHandler;
import com.github.goonjja.gweetie.core.handlers.ModuleLoadingHandler;
import com.github.goonjja.gweetie.core.handlers.NavigationHandler;
import com.github.goonjja.gweetie.core.handlers.ViewManager;
import com.github.goonjja.gweetie.core.navigation.GweetiePlacesProvider;
import com.github.goonjja.gweetie.demo.client.navigation.NavigationPlacesProvider;
import com.github.goonjja.gweetie.demo.client.ui.DefaultLayoutPresenter;

public class GinModule extends GweetieGinModule {
	@Override
	protected Class<? extends GweetiePlacesProvider> getPlacesProviderClass() {
		return NavigationPlacesProvider.class;
	}

	@Override
	protected Class<? extends MessageHandler> getMessageHandler() {
		return DefaultLayoutPresenter.class;
	}

	@Override
	protected Class<? extends ModuleLoadingHandler> getChildModuleLoadingHandler() {
		return DefaultLayoutPresenter.class;
	}

	@Override
	protected Class<? extends NavigationHandler> getNavigationHandler() {
		return DefaultLayoutPresenter.class;
	}

	@Override
	protected Class<? extends ViewManager> getLayoutHandler() {
		return DefaultLayoutPresenter.class;
	}
}
