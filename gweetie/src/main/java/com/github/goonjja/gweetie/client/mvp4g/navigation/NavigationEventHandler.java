package com.github.goonjja.gweetie.client.mvp4g.navigation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.goonjja.gweetie.client.mvp4g.AppEventBus;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.EventHandler;
import com.mvp4g.client.event.BaseEventHandler;

@EventHandler
public class NavigationEventHandler extends BaseEventHandler<AppEventBus> {
	private Map<String, AppPlace> placesHistoryNamesMap = new HashMap<String, AppPlace>();
	private List<String> placesHistoryNames = new ArrayList<String>();
	private boolean attached = false;
	private PlacesProvider placesProvider;

	private ValueChangeHandler<String> historyWatcher = new ValueChangeHandler<String>() {

		@Override
		public void onValueChange(ValueChangeEvent<String> event) {
			handleHistoryChange(event.getValue());
		}
	};

	@Inject
	public NavigationEventHandler(PlacesProvider placesProvider) {
		this.placesProvider = placesProvider;
	}

	public void onInitializeNavigation() {
		if (attached)
			return;
		attached = true;
		for (AppPlace place : getPlaces()) {
			String historyName = AppPlace.Util.getHistoryItemFor(place);
			placesHistoryNames.add(historyName);
			placesHistoryNamesMap.put(historyName, place);
		}
		Collections.sort(placesHistoryNames, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() < o2.length())
					return 1;
				else if (o1.length() > o2.length())
					return -1;
				return 0;
			}
		});

		History.addValueChangeHandler(historyWatcher);
		handleHistoryChange(History.getToken());
	}

	private void handleHistoryChange(String token) {
		GWT.log(token);
		for (String historyName : placesHistoryNames) {
			if (token.startsWith(historyName)) {
				AppPlace place = placesHistoryNamesMap.get(historyName);
				navigated(place);
				return;
			}
		}
	}

	protected void navigated(AppPlace place) {
		eventBus.navigated(place);
	}

	protected AppPlace[] getPlaces() {
		return placesProvider.getPlaces();
	}
}
