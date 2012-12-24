package me.goonjja.gwt.scrim.client.mvp4g.navigation;

import java.util.Map;

public interface TokenGenerator {

	public String convertToToken(String[] tokens, String[] params);

	public String getTokenValue(String token);

	/**
	 * Converts param=value&param1=value1 to ["value","value1"]
	 */
	public Map<String, String> getTokenMap(String[] tokenNames, String token);

}
