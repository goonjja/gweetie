package com.github.goonjja.gweetie.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @author vedernikov
 * @date 21.12.2012
 */
public class Forbidden extends Composite {
	TextBox errorText;
	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	interface MyUiBinder extends UiBinder<Widget, Forbidden> {
	}

	public Forbidden() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setThrowable(Throwable cause) {
		errorText.setText(cause.getMessage());
	}
}