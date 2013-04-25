package com.github.goonjja.gweetie.core.navigation;

/**
 * Interface for places provider class that must return all application's
 * places. Must be defined in Gin module to be injected in
 * NavigationEventHandler.
 * 
 * @author vedernikov
 * @date 21.09.2012
 */
public interface GweetiePlacesProvider {
	GweetiePlace[] getPlaces();

	/**
	 * Sets isCrawlable for GweetieHistoryConverter
	 */
	boolean isCrawlable();
}
