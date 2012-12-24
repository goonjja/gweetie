package me.goonjja.gwt.scrim.client.mvp4g;

import me.goonjja.gwt.scrim.client.mvp4g.navigation.AppTokenGenerator;
import me.goonjja.gwt.scrim.client.mvp4g.navigation.PlacesProvider;
import me.goonjja.gwt.scrim.client.mvp4g.navigation.TokenGenerator;

import com.google.gwt.inject.client.AbstractGinModule;

public abstract class AppGinModule extends AbstractGinModule {

	@Override
	protected final void configure() {
		bind(TokenGenerator.class).to(AppTokenGenerator.class);
		bind(PlacesProvider.class).to(getPlacesProviderClass());
		customConfigure();
	}

	/**
	 * Can be overridden
	 */
	protected void customConfigure() {
	}

	protected abstract Class<? extends PlacesProvider> getPlacesProviderClass();
}
