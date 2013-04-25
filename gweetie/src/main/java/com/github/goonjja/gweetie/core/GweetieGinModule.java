package com.github.goonjja.gweetie.core;

import com.github.goonjja.gweetie.core.handlers.MessageHandler;
import com.github.goonjja.gweetie.core.handlers.ModuleLoadingHandler;
import com.github.goonjja.gweetie.core.handlers.NavigationHandler;
import com.github.goonjja.gweetie.core.handlers.ViewManager;
import com.github.goonjja.gweetie.core.navigation.GweetiePlacesProvider;
import com.github.goonjja.gweetie.core.navigation.GweetieTokenGenerator;
import com.github.goonjja.gweetie.core.navigation.TokenGenerator;
import com.google.gwt.inject.client.AbstractGinModule;

public abstract class GweetieGinModule extends AbstractGinModule {

	@Override
	protected final void configure() {
		bind(TokenGenerator.class).to(GweetieTokenGenerator.class);
		bind(GweetiePlacesProvider.class).to(getPlacesProviderClass());
		bind(MessageHandler.class).to(getMessageHandler());
		bind(ModuleLoadingHandler.class).to(getChildModuleLoadingHandler());
		bind(NavigationHandler.class).to(getNavigationHandler());
		bind(ViewManager.class).to(getLayoutHandler());
	}

	protected abstract Class<? extends GweetiePlacesProvider> getPlacesProviderClass();

	protected abstract Class<? extends MessageHandler> getMessageHandler();

	protected abstract Class<? extends ModuleLoadingHandler> getChildModuleLoadingHandler();

	protected abstract Class<? extends NavigationHandler> getNavigationHandler();

	protected abstract Class<? extends ViewManager> getLayoutHandler();
}
