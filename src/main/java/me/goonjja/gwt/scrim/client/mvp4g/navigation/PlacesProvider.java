package me.goonjja.gwt.scrim.client.mvp4g.navigation;


/**
 * Interface for places provider class that must return all application's
 * places. Must be defined in Gin module to be injected in
 * NavigationEventHandler.
 * 
 * @author vedernikov
 * @date 21.09.2012
 */
public interface PlacesProvider {
	AppPlace[] getPlaces();
}
