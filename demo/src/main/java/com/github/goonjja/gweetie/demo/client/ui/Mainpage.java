package com.github.goonjja.gweetie.demo.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Mainpage extends Composite {

	private static MainpageUiBinder uiBinder = GWT.create(MainpageUiBinder.class);

	interface MainpageUiBinder extends UiBinder<Widget, Mainpage> {
	}

	public Mainpage() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
