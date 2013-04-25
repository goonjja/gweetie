package com.github.goonjja.gweetie.core.navigation;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.goonjja.gweetie.core.GweetieChildEventBus;
import com.github.goonjja.gweetie.core.handlers.MessageType;
import com.google.gwt.user.client.History;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.History.HistoryConverterType;
import com.mvp4g.client.history.HistoryConverter;
import com.mvp4g.client.history.PlaceService;

@com.mvp4g.client.annotation.History(type = HistoryConverterType.SIMPLE)
public class GweetieHistoryConverter implements HistoryConverter<GweetieChildEventBus> {
	private Logger log = Logger.getLogger("Gweetie");

	private GweetiePlace currentPlace = null;
	private TokenGenerator tokenGenerator;
	private GweetiePlacesProvider placesProvider;

	private static Map<String, Map<String, GweetiePlace>> places = new HashMap<String, Map<String, GweetiePlace>>();

	@Inject
	public GweetieHistoryConverter(TokenGenerator tokenGenerator, GweetiePlacesProvider placesProvider) {
		this.tokenGenerator = tokenGenerator;
		this.placesProvider = placesProvider;
		for (GweetiePlace place : getPlaces()) {
			if (places.get(place.getModule()) == null)
				places.put(place.getModule(), new HashMap<String, GweetiePlace>());
			places.get(place.getModule()).put(place.getHistoryName(), place);
			log.info("Initialized place: " + place.getModule() + "/" + place.getHistoryName());
		}
	}

	protected GweetiePlace[] getPlaces() {
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
	public void convertFromToken(String eventName, String param, GweetieChildEventBus eventBus) {
		log.finer("History token: " + eventBus.getHistory().getToken());
		currentPlace = getPlace(eventBus.getHistory().getToken(), eventName);

		if (currentPlace != null) {
			Map<String, String> tokenMap = tokenGenerator.getTokenMap(currentPlace.getArgNames(), param);

			try {
				eventBus.dispatch(eventName, tokenMap.values().toArray(new Object[] {}));
			} catch (Exception e) {
				eventBus.showMessage(MessageType.ERROR, e.getMessage());
				log.log(Level.SEVERE, e.getMessage(), e);
			}
		} else {
			eventBus.showMessage(MessageType.ERROR, "Unknown location: " + eventName);
		}
	}

	private GweetiePlace getPlace(String token, String eventName) {
		String checkToken = token;
		// remove first char if isCrawlable is enabled
		if (isCrawlable() && token.startsWith(PlaceService.CRAWLABLE))
			checkToken = token.substring(1);
		for (String moduleName : places.keySet()) {
			if (moduleName.isEmpty())// skip root module
				continue;
			if (checkToken.startsWith(moduleName + PlaceService.MODULE_SEPARATOR + eventName)) {
				return places.get(moduleName).get(eventName);
			}
		}
		// try to get event from root module
		return places.get("").get(eventName);
	}

	public boolean isCrawlable() {
		return placesProvider.isCrawlable();
	}
}
