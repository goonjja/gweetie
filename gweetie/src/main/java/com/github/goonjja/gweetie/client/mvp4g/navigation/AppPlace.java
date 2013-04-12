package com.github.goonjja.gweetie.client.mvp4g.navigation;

/**
 * Interface for enums that defines places of Mvp4g application. Place is some
 * navigation event, that has name and optionally arguments.
 * 
 * @author Ведерников Сергей
 * @date 20.04.2012
 */
public interface AppPlace {
	String getModule();

	String getHistoryName();

	String[] getArgNames();

	/**
	 * Utility class that generates hyperlinks for places
	 */
	public static class Util {
		/**
		 * Generates link for context(if not present, then root) and place name.
		 * With slash at the end. Example: root place "Contacts", getLink will
		 * return #Contacts/
		 */
		public static String getLink(AppPlace place) {
			return "#" + getHistoryItemFor(place);
		}

		/**
		 * Generates history token for context(if not present, then root) and
		 * place name. With slash at the end. Example: root place "Contacts",
		 * getLink will return Contacts/
		 */
		public static String getHistoryItemFor(AppPlace place) {
			if (place.getModule().equals("")) {
				if (place.getHistoryName().isEmpty())
					return "";
				return place.getHistoryName() + "/";
			} else {
				return place.getModule() + "/" + place.getHistoryName() + "/";
			}
		}
	}
}