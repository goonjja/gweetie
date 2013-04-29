package com.github.goonjja.gweetie.bootstrap;

import java.util.logging.Logger;

import com.google.gwt.core.client.EntryPoint;

public class TwitterBootstrap implements EntryPoint {
	private Logger log = Logger.getLogger("Gweetie");

	@Override
	public void onModuleLoad() {
		ResourceInjector.configure();
		log.info("Twitter Bootstrap and Jquery resources are loaded");
	}
}
