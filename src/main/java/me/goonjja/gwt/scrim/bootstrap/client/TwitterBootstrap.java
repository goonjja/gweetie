package me.goonjja.gwt.scrim.bootstrap.client;

import java.util.logging.Logger;

import com.google.gwt.core.client.EntryPoint;

public class TwitterBootstrap implements EntryPoint {
	Logger log = Logger.getLogger("TwitterBootstrap");

	@Override
	public void onModuleLoad() {
		ResourceInjector.configure();
		log.info("Resources loaded");
	}

}
