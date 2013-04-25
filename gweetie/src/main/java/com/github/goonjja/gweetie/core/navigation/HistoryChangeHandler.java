package com.github.goonjja.gweetie.core.navigation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Singleton;

import com.github.goonjja.gweetie.core.GweetieChildEventBus;
import com.github.goonjja.gweetie.core.util.JSUtils;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.EventHandler;
import com.mvp4g.client.event.BaseEventHandler;
import com.mvp4g.client.history.PlaceService;

@Singleton
@EventHandler(multiple = false)
public class HistoryChangeHandler extends BaseEventHandler<GweetieChildEventBus> {
	private Logger log = Logger.getLogger("Gweetie");
	private Map<String, GweetiePlace> placesHistoryNamesMap = new HashMap<String, GweetiePlace>();
	private List<String> placesHistoryNames = new ArrayList<String>();
	private GweetiePlacesProvider placesProvider;

	private boolean attached = false;

	private ValueChangeHandler<String> historyWatcher = new ValueChangeHandler<String>() {

		@Override
		public void onValueChange(ValueChangeEvent<String> event) {
			handleHistoryChange(event.getValue());
		}
	};

	@Inject
	public HistoryChangeHandler(GweetiePlacesProvider placesProvider) {
		this.placesProvider = placesProvider;
	}

	public void onInitializeHistoryChangeHandler() {
		if (attached)
			return;
		attached = true;
		for (GweetiePlace place : getPlaces()) {
			String historyName = GweetiePlace.Util.getHistoryItemFor(place);
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
//		handleHistoryChange(History.getToken());
	}

	private void handleHistoryChange(String token) {
		log.log(Level.FINE, "History change: " + token);
		String checkToken = token;
		if (placesProvider.isCrawlable() && token.startsWith(PlaceService.CRAWLABLE))
			checkToken = token.substring(1);
		for (String historyName : placesHistoryNames) {
			if (checkToken.startsWith(historyName)) {
				GweetiePlace place = placesHistoryNamesMap.get(historyName);
				eventBus.navigated(place);
				JSUtils.hidePopovers();
				JSUtils.hideTooltips();
				return;
			}
		}
	}

	protected GweetiePlace[] getPlaces() {
		return placesProvider.getPlaces();
	}
}
