package com.github.goonjja.gweetie.client.mvp4g;


import com.github.goonjja.gweetie.client.events.MessageHandler;
import com.github.goonjja.gweetie.client.mvp4g.navigation.AppTokenGenerator;
import com.github.goonjja.gweetie.client.mvp4g.navigation.PlacesProvider;
import com.github.goonjja.gweetie.client.mvp4g.navigation.TokenGenerator;
import com.github.goonjja.gweetie.client.presenters.LayoutPresenter;
import com.google.gwt.inject.client.AbstractGinModule;

public abstract class GweetieGinModule extends AbstractGinModule {

	@Override
	protected final void configure() {
		bind(TokenGenerator.class).to(AppTokenGenerator.class);
		bind(PlacesProvider.class).to(getPlacesProviderClass());
		bind(MessageHandler.class).to(LayoutPresenter.class);
		customConfigure();
	}

	/**
	 * Can be overrided
	 */
	protected void customConfigure() {

	}

	protected abstract Class<? extends PlacesProvider> getPlacesProviderClass();
}
