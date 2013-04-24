package com.github.goonjja.gweetie.demo.client;

import com.github.goonjja.gweetie.client.mvp4g.navigation.GweetiePlace;
import com.github.goonjja.gweetie.client.mvp4g.navigation.PlacesProvider;

public class NavigationPlacesProvider implements PlacesProvider {

	@Override
	public GweetiePlace[] getPlaces() {
		return Places.values();
	}
}
