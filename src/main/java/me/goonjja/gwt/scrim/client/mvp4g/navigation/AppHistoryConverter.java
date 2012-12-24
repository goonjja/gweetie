package me.goonjja.gwt.scrim.client.mvp4g.navigation;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import me.goonjja.gwt.scrim.client.mvp4g.AppEventBus;



import com.google.gwt.user.client.History;
import com.google.inject.Inject;
import com.mvp4g.client.history.HistoryConverter;

public abstract class AppHistoryConverter implements HistoryConverter<AppEventBus> {
	private Logger log = Logger.getLogger("HistoryConverter");
	@Inject
	private TokenGenerator tokenGenerator;

	private AppPlace currentPlace = null;

	private static Map<String, Map<String, AppPlace>> places = new HashMap<String, Map<String, AppPlace>>();

	public AppHistoryConverter() {
		for (AppPlace place : getPlaces()) {
			if (places.get(place.getModule()) == null)
				places.put(place.getModule(), new HashMap<String, AppPlace>());
			places.get(place.getModule()).put(place.getHistoryName(), place);
			log.info("Initialized place: " + place.getModule() + "/" + place.getHistoryName());
		}
	}

	protected abstract AppPlace[] getPlaces();

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
		currentPlace = getPlace(eventBus.getHistory().getToken(), eventName);
		log.info("Convert from token event name:" + eventName);

		if (currentPlace != null) {
			Map<String, String> tokenMap = tokenGenerator.getTokenMap(currentPlace.getArgNames(), param);

			try {
				eventBus.dispatch(eventName, tokenMap.values().toArray(new Object[] {}));
			} catch (Exception e) {
				eventBus.applicationError(e.getMessage());
				log.log(Level.SEVERE, e.getMessage(), e);
			}
		} else {
			eventBus.applicationError("Unknown location: " + eventName);
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
