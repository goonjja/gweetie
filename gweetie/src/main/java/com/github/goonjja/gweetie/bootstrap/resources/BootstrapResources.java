package com.github.goonjja.gweetie.bootstrap.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface BootstrapResources extends ClientBundle {
	public static BootstrapResources INSTANCE = GWT.create(BootstrapResources.class);

	@Source("bootstrap.min.css")
	TextResource bootstrapCss();
	
	@Source("bootstrap-responsive.min.css")
	TextResource bootstrapResponsiveCss();
	
	@Source("navbar-fix.css")
	TextResource navBarFixCss();

	@Source("bootstrap.min.js")
	TextResource bootstrapJs();
	
	@Source("jquery-2.0.0.min.js")
	TextResource jqueryJs();
}
