package com.github.goonjja.gweetie.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Messages;
import com.google.gwt.i18n.client.LocalizableResource.DefaultLocale;

@DefaultLocale("en_US")
public interface FrameworkUIMessages extends Messages {
	public static FrameworkUIMessages INSTANCE = GWT.create(FrameworkUIMessages.class);

	/*
	 * Layout
	 */

	String processingRequest();

	String pageNotFoundMessageTitle();

	String pageNotFoundMessageText();

	String childModuleLoadingError();
	
	String pleaseWait();
}
