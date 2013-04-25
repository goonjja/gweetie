package com.github.goonjja.gweetie.core.navigation;

import com.mvp4g.client.history.PlaceService;

/**
 * @see http://code.google.com/p/mvp4g/wiki/PlaceService
 * @author Ведерников Сергей
 * 
 */
public class GweetiePlaceService extends PlaceService {

	@Override
	protected void convertToken(String token) {
		if (token != null && !token.isEmpty()) {
			if (token.endsWith(MODULE_SEPARATOR) && !token.contains(getParamSeparator())) {
				token = token.substring(0, token.length() - 1);
			}
		}
		super.convertToken(token);
	}

}