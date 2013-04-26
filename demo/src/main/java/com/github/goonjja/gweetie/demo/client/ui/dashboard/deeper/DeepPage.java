package com.github.goonjja.gweetie.demo.client.ui.dashboard.deeper;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class DeepPage extends Composite {

	private static DeepPageUiBinder uiBinder = GWT.create(DeepPageUiBinder.class);

	interface DeepPageUiBinder extends UiBinder<Widget, DeepPage> {
	}

	public DeepPage() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
