package com.github.goonjja.gweetie.demo.client;

import com.github.goonjja.gweetie.client.mvp4g.GweetieGinModule;
import com.github.goonjja.gweetie.client.mvp4g.navigation.PlacesProvider;

public class GinModule extends GweetieGinModule {
	@Override
	protected Class<? extends PlacesProvider> getPlacesProviderClass() {
		return NavigationPlacesProvider.class;
	}

}
