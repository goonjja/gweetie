package com.github.goonjja.gweetie.widgets.client;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Image;

public class ImageAnchor extends Anchor {

	public void setResource(ImageResource imageResource) {
		Image img = new Image(imageResource);
		// img.setStyleName("navbarimg");
		DOM.insertChild(getElement(), img.getElement(), 0);
	}

	public void setRel(String rel) {
		getElement().setAttribute("rel", rel);
	}

}
