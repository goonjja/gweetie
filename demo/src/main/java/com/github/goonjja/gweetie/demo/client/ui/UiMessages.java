package com.github.goonjja.gweetie.demo.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Messages;
import com.google.gwt.i18n.client.LocalizableResource.DefaultLocale;

@DefaultLocale("en_US")
public interface UiMessages extends Messages {
	public static UiMessages INSTANCE = GWT.create(UiMessages.class);

	/*
	 * Layout
	 */

	String processingRequest();

	String pageNotFoundMessageTitle();

	String pageNotFoundMessageText();

	String childModuleLoadingError();
	
	String pleaseWait();
}
