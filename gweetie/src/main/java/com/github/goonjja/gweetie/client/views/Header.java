package com.github.goonjja.gweetie.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @author vedernikov
 * @date 21.12.2012
 */
public class Header extends Composite {

	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	interface MyUiBinder extends UiBinder<Widget, Header> {
	}

	@UiField
	public DivElement navbar;
	@UiField
	public Anchor headAnchor;
	@UiField
	HTMLPanel headerRoot;

	public Header() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public Anchor getHeadAnchor() {
		return headAnchor;
	}
}