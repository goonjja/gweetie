package me.goonjja.gwt.scrim.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @author vedernikov
 * @date 21.12.2012
 */
public class ApplicationError extends Composite {
	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	interface MyUiBinder extends UiBinder<Widget, ApplicationError> {
	}

	@UiField
	public HTML errorMessageHTML;

	public ApplicationError() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setMessage(String message) {
		errorMessageHTML.setHTML(message);
	}
}