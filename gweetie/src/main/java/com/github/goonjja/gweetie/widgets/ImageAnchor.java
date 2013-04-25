package com.github.goonjja.gweetie.widgets;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Image;

public class ImageAnchor extends Anchor {

	public void setResource(ImageResource imageResource) {
		Image img = new Image(imageResource);
		// img.setStyleName("navbarimg");
		DOM.insertBefore(getElement(), img.getElement(), DOM.getFirstChild(getElement()));
	}

	public void setRel(String rel) {
		getElement().setAttribute("rel", rel);
	}

}
