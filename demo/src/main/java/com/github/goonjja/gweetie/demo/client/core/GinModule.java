package com.github.goonjja.gweetie.demo.client.core;

import com.github.goonjja.gweetie.core.GweetieGinModule;
import com.github.goonjja.gweetie.core.handlers.MessageHandler;
import com.github.goonjja.gweetie.core.handlers.ModuleLoadingHandler;
import com.github.goonjja.gweetie.core.handlers.NavigationHandler;
import com.github.goonjja.gweetie.core.handlers.ViewManager;
import com.github.goonjja.gweetie.core.navigation.GweetiePlacesProvider;
import com.github.goonjja.gweetie.demo.client.navigation.NavigationPlacesProvider;
import com.github.goonjja.gweetie.demo.client.presenters.HeaderPresenter;
import com.github.goonjja.gweetie.demo.client.presenters.LayoutPresenter;

public class GinModule extends GweetieGinModule {
	@Override
	protected Class<? extends GweetiePlacesProvider> getPlacesProviderClass() {
		return NavigationPlacesProvider.class;
	}

	@Override
	protected Class<? extends MessageHandler> getMessageHandler() {
		return LayoutPresenter.class;
	}

	@Override
	protected Class<? extends ModuleLoadingHandler> getChildModuleLoadingHandler() {
		return LayoutPresenter.class;
	}

	@Override
	protected Class<? extends NavigationHandler> getNavigationHandler() {
		return HeaderPresenter.class;
	}

	@Override
	protected Class<? extends ViewManager> getLayoutHandler() {
		return LayoutPresenter.class;
	}
}
