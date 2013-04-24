package com.github.goonjja.gweetie.client.mvp4g.navigation;

import com.google.gwt.core.client.GWT;
import com.mvp4g.client.history.PlaceService;

/**
 * @see http://code.google.com/p/mvp4g/wiki/PlaceService
 * @author Ведерников Сергей
 * 
 */
public class GweetiePlaceService extends PlaceService {

	@Override
	public String tokenize(String eventName, String param) {
		GWT.log("Place service tokenize: (" + eventName + "," + param + ")");
		// always add the paramSeparator since "/" is used for module separator
		// and paramSeparator
		String token = eventName + getParamSeparator();
		if ((param != null) && (param.length() > 0)) {
			token = token + param;
		}
		return token;
	}

	protected String getParamSeparator() {
		return "/";
	}

}