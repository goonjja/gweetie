package com.github.goonjja.gweetie.client.mvp4g.navigation;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.goonjja.gweetie.client.mvp4g.AppEventBus;
import com.google.gwt.user.client.History;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.History.HistoryConverterType;
import com.mvp4g.client.history.HistoryConverter;

@com.mvp4g.client.annotation.History(type = HistoryConverterType.SIMPLE)
public class AppHistoryConverter implements HistoryConverter<AppEventBus> {
	private Logger log = Logger.getLogger("HistoryConverter");

	private AppPlace currentPlace = null;
	private TokenGenerator tokenGenerator;
	private PlacesProvider placesProvider;

	private static Map<String, Map<String, AppPlace>> places = new HashMap<String, Map<String, AppPlace>>();

	@Inject
	public AppHistoryConverter(TokenGenerator tokenGenerator, PlacesProvider placesProvider) {
		this.tokenGenerator = tokenGenerator;
		this.placesProvider = placesProvider;
		for (AppPlace place : getPlaces()) {
			if (places.get(place.getModule()) == null)
				places.put(place.getModule(), new HashMap<String, AppPlace>());
			places.get(place.getModule()).put(place.getHistoryName(), place);
			log.info("Initialized place: " + place.getModule() + "/" + place.getHistoryName());
		}
	}

	protected AppPlace[] getPlaces() {
		return placesProvider.getPlaces();
	}

	public String convertToToken(String eventName, String... params) {
		currentPlace = getPlace(History.getToken(), eventName);

		// get token names
		if (currentPlace != null && currentPlace.getArgNames() != null)
			return tokenGenerator.convertToToken(currentPlace.getArgNames(), params);
		// place has no arguments
		return "";
	}

	// this method works only if all events has String arguments or no
	// arguments
	public void convertFromToken(String eventName, String param, AppEventBus eventBus) {
		log.info("Convert from token event name:" + eventName);
		currentPlace = getPlace(eventBus.getHistory().getToken(), eventName);

		if (currentPlace != null) {
			Map<String, String> tokenMap = tokenGenerator.getTokenMap(currentPlace.getArgNames(), param);

			try {
				eventBus.dispatch(eventName, tokenMap.values().toArray(new Object[] {}));
			} catch (Exception e) {
				// eventBus.applicationError(e.getMessage());
				// TODO ERROR
				log.log(Level.SEVERE, e.getMessage(), e);
			}
		} else {
			// eventBus.applicationError("Unknown location: " + eventName);
			// TODO ERROR
		}
	}

	private AppPlace getPlace(String token, String eventName) {
		for (String moduleName : places.keySet()) {
			if (moduleName.isEmpty())// skip root module
				continue;
			if (token.startsWith(moduleName)) {
				return places.get(moduleName).get(eventName);
			}
		}
		// try to get event from root module
		return places.get("").get(eventName);
	}

	public boolean isCrawlable() {
		return false;
	}
}
