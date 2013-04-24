package com.github.goonjja.gweetie.demo.client.child;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ChildView extends Composite {

	private static ChildViewUiBinder uiBinder = GWT.create(ChildViewUiBinder.class);

	interface ChildViewUiBinder extends UiBinder<Widget, ChildView> {
	}

	public ChildView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
