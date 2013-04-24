package com.github.goonjja.gweetie.client.mvp4g;

import com.github.goonjja.gweetie.client.core.ApplicationInitializer;
import com.github.goonjja.gweetie.client.core.ChildModuleLoadingHandler;
import com.github.goonjja.gweetie.client.core.LayoutHandler;
import com.github.goonjja.gweetie.client.core.MessageHandler;
import com.github.goonjja.gweetie.client.core.NavigationHandler;
import com.github.goonjja.gweetie.client.core.UiLockHandler;
import com.github.goonjja.gweetie.client.mvp4g.navigation.GweetieTokenGenerator;
import com.github.goonjja.gweetie.client.mvp4g.navigation.PlacesProvider;
import com.github.goonjja.gweetie.client.mvp4g.navigation.TokenGenerator;
import com.google.gwt.inject.client.AbstractGinModule;

public abstract class GweetieGinModule extends AbstractGinModule {

	@Override
	protected final void configure() {
		bind(TokenGenerator.class).to(GweetieTokenGenerator.class);
		bind(PlacesProvider.class).to(getPlacesProviderClass());
		bind(ApplicationInitializer.class).to(getApplicationInitializer());
		bind(MessageHandler.class).to(getMessageHandler());
		bind(ChildModuleLoadingHandler.class).to(getChildModuleLoadingHandler());
		bind(NavigationHandler.class).to(getNavigationHandler());
		bind(UiLockHandler.class).to(getUiLockHandler());
		bind(LayoutHandler.class).to(getLayoutHandler());
		
		customConfigure();
	}

	/**
	 * Can be overrided
	 */
	protected void customConfigure() {

	}

	protected abstract Class<? extends PlacesProvider> getPlacesProviderClass();

	protected abstract Class<? extends ApplicationInitializer> getApplicationInitializer();

	protected abstract Class<? extends MessageHandler> getMessageHandler();

	protected abstract Class<? extends ChildModuleLoadingHandler> getChildModuleLoadingHandler();

	protected abstract Class<? extends NavigationHandler> getNavigationHandler();

	protected abstract Class<? extends UiLockHandler> getUiLockHandler();

	protected abstract Class<? extends LayoutHandler> getLayoutHandler();
}
