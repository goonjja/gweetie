package com.github.goonjja.gweetie.bootstrap.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class TwitterBootstrap implements EntryPoint {
	@Override
	public void onModuleLoad() {
		ResourceInjector.configure();
		GWT.log("Twitter Bootstrap and Jquery resources are loaded");
	}
}
