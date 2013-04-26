package com.github.goonjja.gweetie.demo.client.navigation;

import com.github.goonjja.gweetie.core.navigation.GweetiePlace;
import com.github.goonjja.gweetie.core.navigation.GweetiePlacesProvider;

public class NavigationPlacesProvider implements GweetiePlacesProvider {

	@Override
	public GweetiePlace[] getPlaces() {
		return Places.values();
	}

	@Override
	public boolean isCrawlable() {
		return true;
	}
}
