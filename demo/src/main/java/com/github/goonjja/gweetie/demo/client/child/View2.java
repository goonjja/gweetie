package com.github.goonjja.gweetie.demo.client.child;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class View2 extends Composite {

	private static View2UiBinder uiBinder = GWT.create(View2UiBinder.class);

	interface View2UiBinder extends UiBinder<Widget, View2> {
	}

	public View2() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
